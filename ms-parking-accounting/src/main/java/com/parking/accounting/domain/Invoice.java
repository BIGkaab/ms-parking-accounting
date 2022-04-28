package com.parking.accounting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private int id;
    private Integer employeeId;
    private Integer spaceParkingId;
    private String issueDate;
    private String licensePlate;
    private Double parkingTime;
    private Double amount;
    private Double hourlyPrice;
    private String currency;
    private String paymentType;
    private Boolean paymented;
}
