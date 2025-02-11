package org.example.idus_exam.member;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;


    @RequestMapping("/signup")
    public void signup(@RequestBody MemberDto.signupRequest dto ){

        memberService.save(dto );


    }
    @RequestMapping("/logout")
    public void logout(){
        memberService.logout();

    }
    @RequestMapping("/profile/{memberidx}")
    public void profile(@PathVariable Long memberidx){
        memberService.find(memberidx);

    }



}
