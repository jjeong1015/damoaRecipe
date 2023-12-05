package com.example.damoaRecipe.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 모든 멤버 조회
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() { // ResponseEntity : HttpRequest에 대한 응답 데이터 포함 -> HttpStatus, HttpHeaders, HttpBody를 포함
        List<Member> members = memberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // memberId로 멤버 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long memberId) {
        Optional<Member> member = memberService.getMemberById(memberId);
        return member.map(value -> new ResponseEntity<>(value, HttpStatus.OK)) // map() : 원하는 형태로 Optional 객체를 변환
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // .orElseGet() : null일 경우에만 호출
    }

    // 멤버 생성
    @PostMapping("/{memberId}")
    public ResponseEntity<Member> createMember(@RequestBody MemberDTO memberDTO) { // @RequestBody : 클라이언트 -> 서버 요청(json 기반의 HTTP body를 자바 객체로 변환), @ResponseBody : 서버 -> 클라이언트 응답(자바 객체를 json 기반의 HTTP body로 변환)
        // @RequestBody는 본문의 내용을 매핑해서 Member(Entity) 객체 생성
        Member createdMember = memberService.createMember(memberDTO);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    // 멤버 업데이트
    @PutMapping("/{memberId}") //  Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect)
    public ResponseEntity<Member> updateMember(@PathVariable Long memberId, @RequestBody MemberDTO memberDTO) {
        Optional<Member> updatedMember = memberService.updateMember(memberId, memberDTO);

        return updatedMember.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 멤버 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        Optional<Member> member = memberService.getMemberById(memberId);
        if (member.isPresent()) {
            memberService.deleteMember(memberId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}