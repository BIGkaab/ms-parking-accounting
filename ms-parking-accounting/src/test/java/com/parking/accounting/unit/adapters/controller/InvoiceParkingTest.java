package com.parking.accounting.unit.adapters.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parking.accounting.DummyData;
import com.parking.accounting.adapters.controller.InvoiceParkingController;
import com.parking.accounting.application.port.in.CreateInvoiceParkingCommandService;
import com.parking.accounting.application.port.in.GetInvoiceParkingQueryService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.parking.accounting.config.utils.Emun.ROUTE_INVOICES;
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
    void getInvoicesOkTest() throws Exception{
        when(modelMapper.map(any(), any())).thenReturn(DummyData.invoiceParkingDto);
        mockMvc.perform(get(ROUTE_INVOICES)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse();
    }

}
