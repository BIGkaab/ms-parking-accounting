package com.parking.accounting.application.usescases;

import com.parking.accounting.application.port.in.CreateInvoiceParkingCommandService;
import com.parking.accounting.application.port.out.InvoiceParkingRepository;
import com.parking.accounting.domain.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CreateInvoiceParkingUsesCase implements CreateInvoiceParkingCommandService {

    private final InvoiceParkingRepository invoiceParkingRepository;

    @Override
    public Invoice execute(Invoice invoice) {
        String[] parts = invoice.getParkingTime().toString().split(":");
        String timeString = parts[0] + "." + parts[1];
        invoice.setAmount(new BigDecimal(timeString).multiply(invoice.getHourlyPrice()));
        return invoiceParkingRepository.create(invoice);
    }
}
