package com.example.damoa.member;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping("/signup") // 회원가입을 위한 템플릿 렌더링
    public String signup(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        System.out.println("GetMapping");
        return "/html/user/signup";
    }

    @PostMapping("/signup") // 회원가입 진행
    public String signup(MemberDTO memberDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) { // bindingResult : 검증 오류 보관 객체
            return "/html/user/signup";
        }

        System.out.println("PostMapping");

        try {
            memberService.createMember(memberDTO);
        } catch (Exception e) {
            model.addAttribute("signupFailed", "회원가입 실패");
            System.out.println("회원가입 실패");
            return "/html/user/signup";
        }
        return "redirect:/login";
    }
}