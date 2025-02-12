package org.example.idus_exam.order;


import io.swagger.v3.oas.annotations.Operation;
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
//
//    @PostMapping("/save")
//    public void order(@RequestBody OrderDto.orderReq dto ,@AuthenticationPrincipal Member member) {
//
//
//
//
//        orderService.save(dto ,member);
//
//
//    }
    @Operation(summary = "단일 회원의 주문 목록 조회", description = "단일 회원의 주문 목록 조회입니다.")
    @GetMapping("/orders/{orderIdx}")
    public ResponseEntity<OrderDto.UserOrderResponse> read(@PathVariable Long orderIdx){
        OrderDto.UserOrderResponse response = orderService.find(orderIdx);

        return ResponseEntity.ok(response);
    }



    @Operation(summary = "강의 등록", description = "강의를 등록하는 기능입니다.")
    @GetMapping("/list")
    public ResponseEntity<OrderDto.OrderPageResponse> list(int page, int size) {

        // TODO  list 검색시 1명당 최대 1개의 최신 주문 목록 표시해야함
        // containing 써야함

        // 지금은 전체 조회 되어가지고안  되는 중     !&*@#&!^@%#^&
        OrderDto.OrderPageResponse response = orderService.list(page, size);

        return ResponseEntity.ok(response);
    }




}
