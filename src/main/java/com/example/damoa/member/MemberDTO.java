package com.example.damoa.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class MemberDTO {

    private Long memberId;
    private String memberPassword;
    // private String memberCheckPassword;
    private String memberName;
    private String memberEmail;
    private String memberImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private MemberStatus memberStatus;

    // 기본 생성자
    public MemberDTO() {
    }

    // 매개변수를 받는 생성자
    public MemberDTO(Long memberId, String memberPassword, String memberName, String memberEmail, String memberImage /* , LocalDateTime updatedAt*/) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        // this.memberCheckPassword = memberCheckPassword;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberImage = memberImage;
        // this.updatedAt = updatedAt;
    }
    // toString() 등의 다른 메서드도 추가할 수 있습니다.
}
