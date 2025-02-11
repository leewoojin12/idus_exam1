package org.example.idus_exam.order;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.idus_exam.member.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;
    @RequestMapping("/save")
    public void order(@RequestBody OrderDto.orderReq dto ,@AuthenticationPrincipal Member member) {




        orderService.save(dto ,member);


    }
    @RequestMapping("/{orderidx}")
    public ResponseEntity<List<Order>> read(@PathVariable Long idx){
//        List<Order> orderlist = orderService.find(idx);

        return null;
    }



    @RequestMapping("/list")
    public ResponseBody aa(){

    }




}
