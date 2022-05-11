package com.parking.accounting.adapters.controller;

import com.parking.accounting.adapters.controller.dto.InvoiceParkingDto;
import com.parking.accounting.application.port.in.CreateInvoiceParkingCommandService;
import com.parking.accounting.application.port.in.GetInvoiceParkingQueryService;
import com.parking.accounting.config.exception.ResponseException;
import com.parking.accounting.domain.Invoice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.parking.accounting.config.utils.Emun.*;

@RestController
@AllArgsConstructor
@ApiOperation(value = ROUTE_INVOICES, tags = "Invoices Parking Controller")
@RequestMapping(ROUTE_INVOICES)
public class InvoiceParkingController {

    private final ModelMapper modelMapper;
    private final CreateInvoiceParkingCommandService createInvoiceParkingCommandService;
    private final GetInvoiceParkingQueryService getInvoiceParkingQueryService;

    @ApiOperation(value = "New Invoice", notes = "Endpoint to save a new invoice", response = InvoiceParkingDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = API_RESPONSE_201, response = InvoiceParkingDto.class),
            @ApiResponse(code = 401, message = API_RESPONSE_401, response = ResponseException.class),
            @ApiResponse(code = 403, message = API_RESPONSE_403, response = ResponseException.class),
            @ApiResponse(code = 404, message = API_RESPONSE_404, response = ResponseException.class),
            @ApiResponse(code = 500, message = API_RESPONSE_500, response = ResponseException.class)

    })
    @PostMapping()
    public ResponseEntity<InvoiceParkingDto> post(@RequestBody @Valid InvoiceParkingDto invoice){
        Invoice data = createInvoiceParkingCommandService.execute(modelMapper.map(invoice, Invoice.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(data, InvoiceParkingDto.class));

    }

    @ApiOperation(value = "List Invoices", notes = "Endpoint to list invoices", response = InvoiceParkingDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = API_RESPONSE_200, response = InvoiceParkingDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = API_RESPONSE_401, response = ResponseException.class),
            @ApiResponse(code = 403, message = API_RESPONSE_403, response = ResponseException.class),
            @ApiResponse(code = 404, message = API_RESPONSE_404, response = ResponseException.class),
            @ApiResponse(code = 500, message = API_RESPONSE_500, response = ResponseException.class)
    })
    @GetMapping()
    public ResponseEntity<List<InvoiceParkingDto>> get(){
        List<InvoiceParkingDto> InvoiceDto = new ArrayList<>();
        List<Invoice> Invoices = getInvoiceParkingQueryService.execute();
        Invoices.forEach(invoice -> InvoiceDto.add(modelMapper.map(invoice, InvoiceParkingDto.class)));
        return ResponseEntity.ok().body(InvoiceDto);
    }

}
