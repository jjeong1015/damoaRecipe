package com.example.damoaRecipe.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class MemberTest {
    @Autowired
    MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Autowired
    public MemberTest(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @Test
    public void member_create() throws Exception {

        Member member = new Member("0718", "이태민", "taem0718@naver.com", "아기치즈태민");

        Member savedMember = memberRepository.save(member);

        assertThat(savedMember.getMemberName()).isEqualTo(member.getMemberName());

    }

    @Test
    public void member_update() throws Exception {

        Member member = new Member("0718", "이태민", "taem0718@naver.com", "아기치즈태민");
        member.setMemberPw("0408");
        member.setMemberName("김종현");
        member.setMemberEmail("jjong0408@naver.com");
        member.setMemberImage("블링블링이즈종현");
        member.setUpdatedAt(LocalDateTime.now());
        memberRepository.save(member);
    }

    @Test
    public void member_delete() throws Exception {

        Member member = new Member("0718", "이태민", "taem0718@naver.com", "아기치즈태민");
        Member savedMember = memberRepository.save(member);
        System.out.println("memberId : " + savedMember.getMemberId());
        memberRepository.deleteById(savedMember.getMemberId());
    }
}