package org.example.idus_exam.member;


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
    @PostMapping("/profile/{memberidx}")
    public void profile(@PathVariable Long memberidx){
//        memberService.find(memberidx);

    }



}
