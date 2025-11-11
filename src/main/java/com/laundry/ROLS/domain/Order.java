package com.laundry.ROLS.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "`Order`")
@Getter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Integer id;                       //주문ID

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private LocalDateTime registeredAt;    //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;             //주문상태 [RECEIVED,IN_PROGRESS]

    private Boolean delivery;
    private LocalDate pickupDate;
    private LocalDate deliveryDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Payment> payments;
}
