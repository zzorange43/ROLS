package com.laundry.ROLS.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessStep {
    @Id
    private Integer stepId;

    private String name;
    private Integer sequence;

    @OneToMany(mappedBy = "processStep", cascade = CascadeType.ALL)
    private List<OrderItemProcess> orderItemProcesses;

}
