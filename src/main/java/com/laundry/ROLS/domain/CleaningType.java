package com.laundry.ROLS.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CleaningType {
    @Id
    private Integer cleaningTypeId;

    private String name;
    private Integer defaultDuration;
    private Integer extraPrice;

    @OneToMany(mappedBy = "cleaningType", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private final List<OrderItemCleaningType> orderItems = new ArrayList<>();
}
