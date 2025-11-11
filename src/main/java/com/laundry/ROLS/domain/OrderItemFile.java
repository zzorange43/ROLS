package com.laundry.ROLS.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemFile {
    @Id
    private Integer fileId;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private OrderItem orderItem;

    private String fileUrl;
    private String description;
    private LocalDate uploadedAt;
}
