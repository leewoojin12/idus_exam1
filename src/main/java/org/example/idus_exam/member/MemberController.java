package org.example.idus_exam.member;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.idus_exam.order.OrderDto;
import org.example.idus_exam.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "회원 기능")
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;
    private final OrderService orderService;


    @Operation(summary = "회원가입", description = "회원가입을 하는 기능입니다.")
     @PostMapping("/signup")
    public void signup(@RequestBody MemberDto.SignupRequest dto ){

        memberService.save(dto);


    }
    @Operation(summary = "회원정보", description = "회원정보 보는기능입니다.")
    @GetMapping("/profile/{memberidx}")
    public ResponseEntity<MemberDto.UserResponse> profile(@PathVariable Long memberidx){
        MemberDto.UserResponse response = memberService.find(memberidx);


        return ResponseEntity.ok(response);

    }


//    @Operation(summary = "로그아웃", description = "로그아웃을 하는 기능입니다.")
//    @PostMapping("/logout")
//    public String logout(HttpServletResponse response) {
//        memberService.deleteCookie(response, "ATOKEN");
//        return "로그아웃 됐음";
//    }



}
