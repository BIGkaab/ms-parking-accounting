package com.parking.accounting;

import com.parking.accounting.adapters.controller.dto.InvoiceParkingDto;
import com.parking.accounting.adapters.external.jpa.entity.InvoiceEntity;
import com.parking.accounting.domain.Invoice;

public class DummyData {
    public static InvoiceParkingDto invoiceParkingDto = InvoiceParkingDto.builder().id(1).employeeId(1).spaceParkingId(1).issueDate("2022-05-09").licensePlate("XDXDXD").parkingTime(16.3).amount(32.6).hourlyPrice(2.0).currency("USD").paymentType("credit").paymented(true).build();
    public static InvoiceParkingDto invoiceBadRequest = InvoiceParkingDto.builder().id(1).employeeId(1).spaceParkingId(1).issueDate("2022-05-09").licensePlate("XDXDXD").parkingTime(16.3).amount(32.6).build();
    public static Invoice invoice = Invoice.builder().id(1).employeeId(1).spaceParkingId(1).issueDate("2022-05-09").licensePlate("XDXDXD").parkingTime(16.3).amount(32.6).hourlyPrice(2.0).currency("USD").paymentType("credit").paymented(true).build();
    public static InvoiceEntity invoiceEntity = InvoiceEntity.builder().id(1).employeeId(1).spaceParkingId(1).issueDate("2022-05-09").licensePlate("XDXDXD").parkingTime(16.3).amount(32.6).hourlyPrice(2.0).currency("USD").paymentType("credit").paymented(true).build();


}
