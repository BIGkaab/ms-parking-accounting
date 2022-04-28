package com.parking.accounting.adapters.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the invoice")
public class InvoiceParkingDto {

    private int id;

    @ApiModelProperty(value = "1", required = true, notes = "employee identification number", example = "99")
    @NotNull(message = "the employeeId cannot be empty")
    private Integer employeeId;

    @ApiModelProperty(value = "1", required = true, notes = "Edentification number of the parking space")
    @NotNull(message = "the spaceParkingId cannot be empty")
    private Integer spaceParkingId;

    @ApiModelProperty(value = "2022-04-19", required = true, notes = "Payment date")
    @NotNull(message = "the issueDate cannot be empty")
    private String issueDate;

    @ApiModelProperty(value = "HOYCBB", required = true, notes = "vehicle plate code")
    @NotNull(message = "the licensePlate cannot be empty")
    private String licensePlate;

    @ApiModelProperty(value = "16:30:00", required = true, notes = "Vehicle parking time")
    @NotNull(message = "the parkingTime cannot be empty")
    private Double parkingTime;

    private Double amount;

    @ApiModelProperty(value = "2", required = true, notes = "parking price per hour")
    @NotNull(message = "the hourlyPrice cannot be empty")
    private Double hourlyPrice;

    @ApiModelProperty(value = "USD", required = true, notes = "type of currency")
    @NotNull(message = "the currency cannot be empty")
    private String currency;

    @ApiModelProperty(value = "credit", required = true, notes = "payment type")
    @NotNull(message = "the paymentType cannot be empty")
    private String paymentType;

    @ApiModelProperty(value = "true", required = true, notes = "Payment confirmation")
    @NotNull(message = "the paymented cannot be empty")
    private Boolean paymented;

}
