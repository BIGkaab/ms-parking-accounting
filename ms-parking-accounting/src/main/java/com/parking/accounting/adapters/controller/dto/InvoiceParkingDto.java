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

    @ApiModelProperty(value = "1", example = "1")
    private int id;

    @ApiModelProperty(value = "1", required = true, notes = "employee identification number", example = "1")
    @NotNull(message = "the employeeId cannot be empty")
    private Integer employeeId;

    @ApiModelProperty(value = "1", required = true, notes = "Edentification number of the parking space", example = "1")
    @NotNull(message = "the spaceParkingId cannot be empty")
    private Integer spaceParkingId;

    @ApiModelProperty(value = "2022-04-19", required = true, notes = "Payment date", example = "2022-04-19")
    @NotNull(message = "the issueDate cannot be empty")
    private String issueDate;

    @ApiModelProperty(value = "HOYCBB", required = true, notes = "vehicle plate code", example = "HOYCBB")
    @NotNull(message = "the licensePlate cannot be empty")
    private String licensePlate;

    @ApiModelProperty(value = "16.30", required = true, notes = "Vehicle parking time", example = "16.30")
    @NotNull(message = "the parkingTime cannot be empty")
    private Double parkingTime;

    @ApiModelProperty(value = "32.60", example = "32.60")
    private Double amount;

    @ApiModelProperty(value = "2.0", required = true, notes = "parking price per hour", example = "2.0")
    @NotNull(message = "the hourlyPrice cannot be empty")
    private Double hourlyPrice;

    @ApiModelProperty(value = "USD", required = true, notes = "type of currency", example = "USD")
    @NotNull(message = "the currency cannot be empty")
    private String currency;

    @ApiModelProperty(value = "credit", required = true, notes = "payment type", example = "credit")
    @NotNull(message = "the paymentType cannot be empty")
    private String paymentType;

    @ApiModelProperty(value = "true", required = true, notes = "Payment confirmation", example = "true")
    @NotNull(message = "the paymented cannot be empty")
    private Boolean paymented;

}
