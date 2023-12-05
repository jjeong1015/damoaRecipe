package com.example.damoaRecipe.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "member")
public class Member {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String memberPw;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false, unique = true)
    private String memberEmail;

    private String memberImage;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Version
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    /* 레시피랑 리뷰 테이블 완성되면 주석 풀 예정
    @OneToMany
    @JoinColumn(name="member_id")
    private List<Recipe> recipes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="member_id")
    private List<Review> reviews = new ArrayList<>();
    */

    // 생성자
    protected Member() {} // JPA 사용을 위해 기본 생성자 보호

    @Builder
    public Member(String memberPw, String memberName, String memberEmail, String memberImage) {
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberImage = memberImage;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.memberStatus = MemberStatus.ACTIVE; // 기본 상태 설정
    }

    // Getter 및 Setter는 필요에 따라 추가

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberPw='" + memberPw + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberImage='" + memberImage + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", memberStatus=" + memberStatus +
                '}';
    }

    public void updateMember(String memberPw, String memberName, String memberEmail, String memberImage) {
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberImage = memberImage;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}


