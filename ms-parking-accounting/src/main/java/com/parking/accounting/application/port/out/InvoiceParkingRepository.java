package com.parking.accounting.application.port.out;

import com.parking.accounting.domain.Invoice;

import java.util.List;

public interface InvoiceParkingRepository {
    Invoice create(Invoice invoice);
    List<Invoice> FindAll();
}
