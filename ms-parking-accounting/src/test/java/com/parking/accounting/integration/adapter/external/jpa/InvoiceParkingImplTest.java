package com.parking.accounting.integration.adapter.external.jpa;

import com.parking.accounting.DummyData;
import com.parking.accounting.MsParkingAccountingApplication;
import com.parking.accounting.application.port.out.InvoiceParkingRepository;
import com.parking.accounting.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MsParkingAccountingApplication.class)
public class InvoiceParkingImplTest {

    @Autowired
    InvoiceParkingRepository invoiceParkingRepository;

    @Test
    public void createOk(){
        Invoice invoice = invoiceParkingRepository.create(DummyData.invoice);
        assertEquals(DummyData.invoice, invoice);
    }

    @Test
    public void FindAll(){
        List<Invoice> invoices = invoiceParkingRepository.FindAll();
        List<Invoice> invoicesExpected = new ArrayList<>();
        invoicesExpected.add(DummyData.invoice);
        assertEquals(invoicesExpected, invoices);
    }
}
