package com.example.damoa.member;

import com.example.damoa.recipe.Recipe;
// import com.example.damoa.review.Review;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(nullable = false)
    private String memberPassword;

//    @Column(nullable = false)
//    private String memberCheckPassword;

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

    // 레시피랑 리뷰 테이블 완성되면 주석 풀 예정
    @OneToMany(mappedBy = "member")
    private List<Recipe> recipes = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<Review> reviews = new ArrayList<>();

    // 생성자
    protected Member() {} // JPA 사용을 위해 기본 생성자 보호

    @Builder
    public Member(String memberPassword, String memberName, String memberEmail, String memberImage) {
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberImage = memberImage;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.memberStatus = MemberStatus.ACTIVE; // 기본 상태 설정
    }

    // Getter 및 Setter는 필요에 따라 추가

    public void updateMember(String memberPassword, String memberName, String memberEmail, String memberImage) {
        this.memberPassword = memberPassword;
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