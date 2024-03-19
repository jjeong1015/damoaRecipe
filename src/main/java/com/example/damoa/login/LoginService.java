package com.example.damoa.login;

import com.example.damoa.member.Member;
import com.example.damoa.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final MemberRepository memberRepository;

    @Autowired
    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean authenticate(LoginDTO loginDTO) {
        try {
            // 주어진 이메일로 사용자를 찾습니다.
            Optional<Member> optionalMember = memberRepository.findByMemberEmail(loginDTO.getMemberEmail());

            // 사용자가 존재하고, 패스워드가 일치하는지 확인합니다.
            if (optionalMember.isPresent() && optionalMember.get().getMemberPassword().equals(loginDTO.getMemberPassword())) {
                return true; // 인증 성공
            } else {
                return false; // 패스워드 불일치 또는 사용자 없음
            }
        } catch (Exception e) {
            // 예외가 발생하면 로깅하고 false를 반환합니다.
            // 실제 프로젝트에서는 로깅 및 예외 처리를 더 신중하게 구현해야 합니다.
            e.printStackTrace();
            return false;
        }
    }
}
