package com.laundry.ROLS.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class ItemType {
    @Id
    private Integer itemTypeId;

    private String name;
    private Integer defaultPrice;
}
