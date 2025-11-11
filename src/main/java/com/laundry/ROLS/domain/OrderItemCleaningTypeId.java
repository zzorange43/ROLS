package com.laundry.ROLS.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderItemCleaningTypeId  implements java.io.Serializable{
    private Integer itemId;
    private Integer cleaningTypeId;
}
