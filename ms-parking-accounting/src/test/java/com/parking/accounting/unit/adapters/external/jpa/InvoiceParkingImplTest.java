package com.parking.accounting.unit.adapters.external.jpa;

import com.parking.accounting.DummyData;
import com.parking.accounting.adapters.external.jpa.adapter.InvoiceParkingImpl;
import com.parking.accounting.adapters.external.jpa.adapter.InvoiceParkingPersistence;
import com.parking.accounting.adapters.external.jpa.entity.InvoiceEntity;
import com.parking.accounting.application.port.out.InvoiceParkingRepository;
import com.parking.accounting.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InvoiceParkingImplTest {

    @Mock
    InvoiceParkingPersistence invoiceParkingPersistence;
    @Mock
    ModelMapper modelMapper;
    @InjectMocks
    InvoiceParkingImpl invoiceParkingImp;


    @Test
    void creteInvoiceOkTest(){
        when(invoiceParkingPersistence.save(any())).thenReturn(DummyData.invoiceEntity);
        when(modelMapper.map(any(Invoice.class), any())).thenReturn(DummyData.invoiceEntity);
        when(modelMapper.map(any(InvoiceEntity.class), any())).thenReturn(DummyData.invoice);
        Invoice invoice = invoiceParkingImp.create(DummyData.invoice);
        assertEquals(invoice.getEmployeeId(), DummyData.invoiceEntity.getEmployeeId());
    }

    @Test
    void findAllInvoicesOk(){
        List<InvoiceEntity> invoiceEntities = new ArrayList<>();
        invoiceEntities.add(DummyData.invoiceEntity);
        when(invoiceParkingPersistence.findAll()).thenReturn(invoiceEntities);
        when(modelMapper.map(any(InvoiceEntity.class), any())).thenReturn(DummyData.invoice);
        List<Invoice> invoices = invoiceParkingImp.FindAll();
        assertEquals(invoices.get(0).getEmployeeId(), invoiceEntities.get(0).getEmployeeId());
    }

}
