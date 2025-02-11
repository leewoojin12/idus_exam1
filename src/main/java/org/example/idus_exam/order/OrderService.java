package org.example.idus_exam.order;


import lombok.RequiredArgsConstructor;
import org.example.idus_exam.member.Member;
import org.example.idus_exam.member.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    public void save(OrderDto.orderReq dto, Member member) {


        orderRepository.save(dto.toEntity(member));


    }

    public OrderDto.UserOrderResponse find(Long memberidx) {
        Optional<Member> result = memberRepository.findById(memberidx);

        if (result.isPresent()) {
            Member member = result.get();
            return OrderDto.UserOrderResponse.from(member);
        }

        return null;
    }

    public OrderDto.OrderPageResponse list( int page, int size) {

//        List<Long> memberIds = memberRepository.findAllMemberIdxs();

        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "dateTime"));
        Page<Order> orderPage = orderRepository.findAll(pageable);
        return OrderDto.OrderPageResponse.from(orderPage);



    }
}
