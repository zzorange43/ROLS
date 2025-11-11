package com.laundry.ROLS.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    private Integer itemId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_type_id", nullable = false)
    private ItemType itemType;

    private Integer quantity;
    private Integer basePrice;
    private String requestNote;
    private LocalDate expectedComplete;

    @OneToMany(mappedBy = "orderItem", cascade = CascadeType.ALL)
    @Builder.Default
    private final List<OrderItemCleaningType> cleaningTypes = new ArrayList<>();

    @OneToMany(mappedBy = "orderItem", cascade = CascadeType.ALL)
    @Builder.Default
    private final List<OrderItemProcess> processes = new ArrayList<>();

    @OneToMany(mappedBy = "orderItem", cascade = CascadeType.ALL)
    @Builder.Default
    private final List<OrderItemFile> files = new ArrayList<>();

}
