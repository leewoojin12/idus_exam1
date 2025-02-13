package org.example.idus_exam.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.idus_exam.member.Member;
import org.springframework.data.domain.Page;

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
    public static class UserOrderResponse {
        private Long idx;
        private String name;
        List<OrderResponse> orders = new ArrayList<>();


        public static UserOrderResponse from(Member member) {
            return UserOrderResponse.builder()
                    .idx(member.getIdx())
                    .name(member.getName())
                    .orders(member.getOrders().stream().map(OrderResponse::from).collect(Collectors.toList()))
                    .build();
        }

    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OrderResponse {
        private Long idx;

        @Pattern(regexp = "^[ㄱ-ㅎ가-힣A-Z]+$", message = "이름은 한글 또는 영어 대문자만 입력 가능합니다.")        @Size(max=20 )
        @NotNull
        @Size(max=20 )
        private Long memberidx;
        @NotNull
        @Size(max=100 )

        private String productName;

        @NotNull
        private LocalDateTime dateTime;

        public static OrderResponse from(Order order) {
            return OrderResponse.builder()
                    .idx(order.getIdx())
                    .memberidx(order.getMember().getIdx())
                    .productName(order.getProductName())
                    .dateTime(order.getDateTime())
                    .build();
        }

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OrderPageResponse {
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;
        private boolean hasNext;
        private boolean hasPrevious;

        private List<OrderResponse> orders;

        public static OrderPageResponse from(Page<Order> orderpage) {
            return OrderPageResponse.builder()
                    .page(orderpage.getNumber())
                    .size(orderpage.getSize())
                    .totalElements(orderpage.getTotalElements())
                    .totalPages(orderpage.getTotalPages())
                    .hasNext(orderpage.hasNext())
                    .hasPrevious(orderpage.hasPrevious())
                    .orders(orderpage.stream().map(OrderDto.OrderResponse::from).collect(Collectors.toList()))
                    .build();
        }
    }







}
