package com.example.damoa.member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(Long memberId);
    Optional<Member> findByMemberEmail(String memberEmail);
    Optional<Member> findByMemberPassword(String memberPassword);
    Optional<Member> findByMemberName(String memberName);
}