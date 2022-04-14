package com.parking.accounting.application.port.in;

import com.parking.accounting.domain.Invoice;

public interface CreateInvoiceParkingCommandService {
    Invoice execute(Invoice invoice);
}
