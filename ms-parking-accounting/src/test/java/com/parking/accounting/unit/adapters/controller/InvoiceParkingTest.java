package com.parking.accounting.unit.adapters.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parking.accounting.DummyData;
import com.parking.accounting.adapters.controller.InvoiceParkingController;
import com.parking.accounting.adapters.controller.dto.InvoiceParkingDto;
import com.parking.accounting.application.port.in.CreateInvoiceParkingCommandService;
import com.parking.accounting.application.port.in.GetInvoiceParkingQueryService;
import com.parking.accounting.config.exception.InternalServerErrorException;
import com.parking.accounting.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.parking.accounting.config.utils.Emun.ROUTE_INVOICES;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InvoiceParkingController.class)
public class InvoiceParkingTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    ModelMapper modelMapper;
    @MockBean
    CreateInvoiceParkingCommandService createInvoiceParkingCommandService;
    @MockBean
    GetInvoiceParkingQueryService getInvoiceParkingQueryService;

    @Test
    void createInvoiceOkTest() throws Exception{
        when(modelMapper.map(any(InvoiceParkingDto.class), any())).thenReturn(DummyData.invoice);
        when(modelMapper.map(any(Invoice.class), any())).thenReturn(DummyData.invoiceParkingDto);
        mockMvc.perform(post(ROUTE_INVOICES)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(DummyData.invoiceParkingDto)))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn();
    }

    @Test
    void createInvoiceBabRequestTest() throws Exception{
        mockMvc.perform(post(ROUTE_INVOICES)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DummyData.invoiceBadRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvoiceServerInternalErrorTest() throws Exception{
        when(modelMapper.map(any(InvoiceParkingDto.class), any())).thenReturn(DummyData.invoice);
        when(modelMapper.map(any(Invoice.class), any())).thenReturn(DummyData.invoiceParkingDto);
        when(createInvoiceParkingCommandService.execute(any())).thenThrow(new InternalServerErrorException(any()));
       assertThrows(InternalServerErrorException.class, () -> createInvoiceParkingCommandService.execute(DummyData.invoice));
        mockMvc.perform(post(ROUTE_INVOICES)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DummyData.invoiceParkingDto)))
                .andDo(print())
                .andExpect(status().isInternalServerError()).andReturn();
    }

    @Test
    void getInvoicesOkTest() throws Exception{
        when(modelMapper.map(any(), any())).thenReturn(DummyData.invoiceParkingDto);
        mockMvc.perform(get(ROUTE_INVOICES)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse();
    }

    @Test
    void getInvoicesServerInternalErrorTest() throws Exception{
        when(modelMapper.map(any(InvoiceParkingDto.class), any())).thenReturn(DummyData.invoice);
        when(modelMapper.map(any(Invoice.class), any())).thenReturn(DummyData.invoiceParkingDto);
        when(getInvoiceParkingQueryService.execute()).thenThrow(InternalServerErrorException.class);
        assertThrows(InternalServerErrorException.class, () -> getInvoiceParkingQueryService.execute());
        mockMvc.perform(get(ROUTE_INVOICES)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isInternalServerError()).andReturn();
    }

}
