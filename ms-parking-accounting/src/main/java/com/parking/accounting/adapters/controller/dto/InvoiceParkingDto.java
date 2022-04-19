package com.parking.accounting.adapters.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceParkingDto {

    private int id;

    @NotNull(message = "the employeeId cannot be empty")
    private Integer employeeId;

    @NotNull(message = "the spaceParkingId cannot be empty")
    private Integer spaceParkingId;

    @NotNull(message = "the issueDate cannot be empty")
    private LocalDate issueDate;

    @NotNull(message = "the licensePlate cannot be empty")
    private String licensePlate;

    @NotNull(message = "the parkingTime cannot be empty")
    private LocalTime parkingTime;

    private BigDecimal amount;

    @NotNull(message = "the hourlyPrice cannot be empty")
    private BigDecimal hourlyPrice;

    @NotNull(message = "the currency cannot be empty")
    private String currency;

    @NotNull(message = "the paymentType cannot be empty")
    private String paymentType;

    @NotNull(message = "the paymented cannot be empty")
    private Boolean paymented;
}
