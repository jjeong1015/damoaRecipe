package com.example.damoa.member;


import com.example.damoa.login.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
// @Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 멤버 생성
    public Member createMember(MemberDTO memberDTO) { // String memberPw, String memberName, String memberEmail, String memberImage
        // Member member = new Member(memberPw, memberName, memberEmail, memberImage);
        Member member = new Member(memberDTO.getMemberPassword(), memberDTO.getMemberName(), memberDTO.getMemberEmail(), memberDTO.getMemberImage());
//        Member member = new Member();
//        member.setMemberPw(memberDTO.getMemberPw());
//        member.setMemberName(memberDTO.getMemberName());
//        member.setMemberEmail(memberDTO.getMemberEmail());
//        member.setMemberImage(memberDTO.getMemberImage());
//        member.setCreatedAt(LocalDateTime.now());
//        member.setUpdatedAt(LocalDateTime.now());
//        member.setMemberStatus(MemberStatus.PENDING_ACTIVATION);

        return memberRepository.save(member);
    }

    // 멤버 조회
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    // memberId로 멤버 조회
    public Optional<Member> findByMemberId(Long memberId) {
        return memberRepository.findByMemberId(memberId);
    }

    public Optional<Member> findByMemberName(String memberName) {
        return memberRepository.findByMemberName(memberName);
    }

    // 멤버 업데이트
    public Optional<Member> updateMember(Long memberId, MemberDTO memberDTO) {
        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("memberId가 " + memberId + "인 멤버 존재하지 않음"));
        Member updateMember = member;
        updateMember.setMemberPassword(memberDTO.getMemberPassword());
        updateMember.setMemberName(memberDTO.getMemberName());
        updateMember.setMemberEmail(memberDTO.getMemberEmail());
        updateMember.setMemberImage(memberDTO.getMemberImage());

        return Optional.of(memberRepository.save(updateMember)); // 멤버 업데이트
    }

    // 멤버 삭제
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
