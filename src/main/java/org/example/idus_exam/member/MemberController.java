package org.example.idus_exam.member;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.idus_exam.order.OrderDto;
import org.example.idus_exam.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;
    private final OrderService orderService;


    @PostMapping("/signup")
    public void signup(@RequestBody MemberDto.SignupRequest dto ){

        memberService.save(dto);


    }
    @GetMapping("/profile/{memberidx}")
    public ResponseEntity<MemberDto.UserResponse> profile(@PathVariable Long memberidx){
        MemberDto.UserResponse response = memberService.find(memberidx);


        return ResponseEntity.ok(response);

    }
    private void deleteCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response) {
        deleteCookie(response, "ATOKEN");
        return "로그아웃 됐음";
    }



}
