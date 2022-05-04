package com.parking.accounting;

import com.parking.accounting.adapters.controller.dto.InvoiceParkingDto;

public class DummyData {
    public static InvoiceParkingDto invoiceParkingDto = InvoiceParkingDto.builder().id(1).employeeId(1).spaceParkingId(1).issueDate("2022-05-01").licensePlate("HOYCBB").parkingTime(16.3).amount(32.6).hourlyPrice(2.0).currency("USD").paymentType("credit").paymented(true).build();
    public static InvoiceParkingDto invoiceBadRequest = InvoiceParkingDto.builder().id(1).employeeId(1).spaceParkingId(1).issueDate("2022-05-01").licensePlate("HOYCBB").parkingTime(16.3).amount(32.6).build();



}
