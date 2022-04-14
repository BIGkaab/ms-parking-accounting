package com.parking.accounting.application.usescases;

import com.parking.accounting.application.port.in.CreateInvoiceParkingCommandService;
import com.parking.accounting.application.port.out.InvoiceParkingRepository;
import com.parking.accounting.domain.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateInvoiceParkingUsesCase implements CreateInvoiceParkingCommandService {

    private final InvoiceParkingRepository invoiceParkingRepository;

    @Override
    public Invoice execute(Invoice invoice) {
        return invoiceParkingRepository.create(invoice);
    }
}
