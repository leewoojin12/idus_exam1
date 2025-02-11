package org.example.idus_exam.order;


import lombok.RequiredArgsConstructor;
import org.example.idus_exam.member.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;
    public void save(OrderDto.orderReq dto, Member member) {


        orderRepository.save(dto.toEntity(member));


    }

    public void find (Long idx){
        List<Order> orderList= orderRepository.findById(idx).orElseThrow();

    }
}
