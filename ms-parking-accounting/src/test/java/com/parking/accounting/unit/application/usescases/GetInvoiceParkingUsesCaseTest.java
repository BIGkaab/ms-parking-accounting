package com.parking.accounting.unit.application.usescases;

import com.parking.accounting.DummyData;
import com.parking.accounting.application.port.out.InvoiceParkingRepository;
import com.parking.accounting.application.usescases.GetInvoiceParkingUsesCase;
import com.parking.accounting.config.exception.InternalServerErrorException;
import com.parking.accounting.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.parking.accounting.config.utils.Emun.MESSAGE_INTERNAL_SERVER_ERROR_EXCEPTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetInvoiceParkingUsesCaseTest {

    @Mock
    InvoiceParkingRepository invoiceParkingRepository;
    @InjectMocks
    GetInvoiceParkingUsesCase getInvoiceParkingUsesCase;

    @Test
    void executeOk(){
        List<Invoice> invoicesDummy = new ArrayList<>();
        invoicesDummy.add(DummyData.invoice);
        when(invoiceParkingRepository.FindAll()).thenReturn(invoicesDummy);
        List<Invoice> invoices = getInvoiceParkingUsesCase.execute();
        assertEquals(invoices.get(0).getEmployeeId(), invoicesDummy.get(0).getEmployeeId());
    }

    @Test()
    void executeInternalServerError() {
        when(invoiceParkingRepository.FindAll()).thenThrow();
        Throwable throwable = assertThrows(InternalServerErrorException.class, () -> getInvoiceParkingUsesCase.execute());
        assertEquals(MESSAGE_INTERNAL_SERVER_ERROR_EXCEPTION, throwable.getMessage());
    }

}