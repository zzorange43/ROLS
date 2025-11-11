package com.laundry.ROLS.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderItemCleaningType {
    @EmbeddedId
    private OrderItemCleaningTypeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private OrderItem orderItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cleaningTypeId")
    @JoinColumn(name = "cleaning_type_id")
    private CleaningType cleaningType;
}
