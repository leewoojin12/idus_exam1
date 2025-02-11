package org.example.idus_exam.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.idus_exam.member.Member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDto {

    @Getter
    public static class orderReq {
        private String productName;
        private LocalDateTime dateTime;

        public Order toEntity(Member member) {
            return Order.builder()
                    .productName(productName)
                    .dateTime(dateTime)
                    .member(member)
                    .build();
        }
    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OrderResponse {
        private Long idx;
        private String productName;
        private LocalDateTime dateTime;

        public static OrderResponse from(Order order) {
            return OrderResponse.builder()
                    .idx(order.getIdx())
                    .productName(order.getProductName())
                    .dateTime(order.getDateTime())
                    .build();
        }

    }


}
