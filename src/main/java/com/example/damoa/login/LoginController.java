package com.example.damoa.login;

import com.example.damoa.member.Member;
import com.example.damoa.member.MemberDTO;
import com.example.damoa.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login") // 회원가입을 위한 템플릿 렌더링
    public String login(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "/html/user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, Model model) {
        // 로그인 서비스 메서드를 호출하여 인증 여부 확인
        boolean isAuthenticated = loginService.authenticate(loginDTO);

        if (isAuthenticated) {
            // 인증 성공 시, 세션 등록 또는 필요한 처리를 수행
            // 여기에서는 간단히 세션에 로그인 정보를 추가하는 예제를 보여줍니다.
            // 실제로는 Spring Security 또는 다른 보안 프레임워크를 사용하는 것이 좋습니다.
            model.addAttribute("authenticatedUser", loginDTO.getMemberEmail());

            // 홈 페이지로 리다이렉트
            return "redirect:/";
        } else {
            // 인증 실패 시, 에러 메시지를 모델에 추가
            model.addAttribute("loginFailed", "이메일 또는 비밀번호가 잘못되었습니다.");

            // 로그인 페이지로 이동
            return "/html/user/login";
        }
    }
}
