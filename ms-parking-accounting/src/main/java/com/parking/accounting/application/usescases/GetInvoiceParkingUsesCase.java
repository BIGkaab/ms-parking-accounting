package com.parking.accounting.application.usescases;

import com.parking.accounting.application.port.in.GetInvoiceParkingQueryService;
import com.parking.accounting.application.port.out.InvoiceParkingRepository;
import com.parking.accounting.domain.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetInvoiceParkingUsesCase implements GetInvoiceParkingQueryService {

    private final InvoiceParkingRepository invoiceParkingRepository;

    @Override
    public List<Invoice> execute() {
        return invoiceParkingRepository.FindAll();
    }
}
