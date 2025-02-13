package org.example.idus_exam.order;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.idus_exam.member.Member;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String productName;
    private LocalDateTime dateTime;


    @ManyToOne
    @JoinColumn(name="member_idx")
    private Member member;

}
