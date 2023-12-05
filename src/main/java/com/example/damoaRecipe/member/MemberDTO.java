package com.example.damoaRecipe.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MemberDTO {
    // Getter와 Setter 메서드들
    private Long memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private String memberImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private MemberStatus memberStatus;
    // 추가적으로 필요한 필드가 있다면 추가할 수 있습니다.

    // 기본 생성자
    public MemberDTO() {
    }

    // 매개변수를 받는 생성자
    public MemberDTO(Long memberId, String memberPw, String memberName, String memberEmail, String memberImage /* , LocalDateTime updatedAt*/) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberImage = memberImage;
        //this.updatedAt = updatedAt;
    }

    // toString() 등의 다른 메서드도 추가할 수 있습니다.
}

