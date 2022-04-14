package com.parking.accounting.application.port.in;

import com.parking.accounting.domain.Invoice;

import java.util.List;

public interface GetInvoiceParkingQueryService {
    List<Invoice> execute();

}
