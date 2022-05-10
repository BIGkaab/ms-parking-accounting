package com.parking.accounting.unit.application.usescases;

import com.parking.accounting.DummyData;
import com.parking.accounting.application.port.out.InvoiceParkingRepository;
import com.parking.accounting.application.usescases.CreateInvoiceParkingUsesCase;
import com.parking.accounting.config.exception.InternalServerErrorException;
import com.parking.accounting.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateInvoiceParkingUsesCaseTest {

    @Mock
    InvoiceParkingRepository invoiceParkingRepository;
    @InjectMocks
    CreateInvoiceParkingUsesCase createInvoiceParkingUsesCase;

    @Test
    void executeOk() {
        when(invoiceParkingRepository.create(any())).thenReturn(DummyData.invoice);
        Invoice invoice = createInvoiceParkingUsesCase.execute(DummyData.invoice);
        assertEquals(invoice.getEmployeeId(), DummyData.invoice.getEmployeeId());
    }

    @Test()
    void executeInternalServerError() {
        when(invoiceParkingRepository.create(any())).thenThrow(new InternalServerErrorException(any()));
        Throwable throwable = assertThrows(InternalServerErrorException.class, () -> createInvoiceParkingUsesCase.execute(DummyData.invoice));
        assertEquals("An unexpected error has occurred", throwable.getMessage());
    }
}