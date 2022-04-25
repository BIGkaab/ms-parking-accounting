package com.parking.accounting.adapters.controller;

import com.parking.accounting.adapters.controller.dto.InvoiceParkingDto;
import com.parking.accounting.application.port.in.CreateInvoiceParkingCommandService;
import com.parking.accounting.application.port.in.GetInvoiceParkingQueryService;
import com.parking.accounting.config.exception.BadRequestException;
import com.parking.accounting.domain.Invoice;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoiceParkingController {

    private final ModelMapper modelMapper;
    private final CreateInvoiceParkingCommandService createInvoiceParkingCommandService;
    private final GetInvoiceParkingQueryService getInvoiceParkingQueryService;

    @ApiOperation(value = "New Invoice", notes = "Endpoint to save a new invoice", response = InvoiceParkingDto.class)
    @PostMapping()
    public ResponseEntity<InvoiceParkingDto> post(@RequestBody @Valid InvoiceParkingDto invoice){
        Invoice data = createInvoiceParkingCommandService.execute(modelMapper.map(invoice, Invoice.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(data, InvoiceParkingDto.class));

    }

    @ApiOperation(value = "List Invoices", notes = "Endpoint to list invoices", response = InvoiceParkingDto.class)
    @GetMapping()
    public ResponseEntity<List<InvoiceParkingDto>> get(){
        List<InvoiceParkingDto> InvoiceDto = new ArrayList<>();
        List<Invoice> Invoices = getInvoiceParkingQueryService.execute();
        Invoices.forEach(invoice -> InvoiceDto.add(modelMapper.map(invoice, InvoiceParkingDto.class)));
        return ResponseEntity.ok().body(InvoiceDto);
    }

}
