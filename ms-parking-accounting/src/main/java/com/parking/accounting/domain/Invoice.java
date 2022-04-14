package com.parking.accounting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private int id;
    private Integer employeeId;
    private Integer spaceParkingId;
    private LocalDate issueDate;
    private String licensePlate;
    private LocalTime parkingTime;
    private BigDecimal amount;
    private BigDecimal hourlyPrice;
    private Integer currency;
    private Integer paymentType;
    private Boolean paymented;
}
