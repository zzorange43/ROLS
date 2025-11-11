package com.laundry.ROLS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemProcess {
    @EmbeddedId
    private OrderItemProcessId id;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private OrderItem orderItem;

    @ManyToOne
    @MapsId("stepId")
    @JoinColumn(name = "step_id")
    private ProcessStep processStep;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private ProcessStatus status;
}
