package com.laundry.ROLS.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemProcessId implements java.io.Serializable{
    private Integer itemId;
    private Integer stepId;
}
