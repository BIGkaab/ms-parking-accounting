package com.parking.accounting.adapters.external.jpa.adapter;

import com.parking.accounting.adapters.external.jpa.entity.InvoiceEntity;
import com.parking.accounting.application.port.out.InvoiceParkingRepository;
import com.parking.accounting.domain.Invoice;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class InvoiceParkingImpl implements InvoiceParkingRepository {

    private final InvoiceParkingPersistence invoiceParkingPersistence;
    private final ModelMapper modelMapper;

    @Override
    public Invoice create(Invoice invoice) {
        InvoiceEntity data = invoiceParkingPersistence.save(modelMapper.map(invoice, InvoiceEntity.class));
        return modelMapper.map(data, Invoice.class);
    }

    @Override
    public List<Invoice> FindAll() {
        List<Invoice> invoice = new ArrayList<>();
        List<InvoiceEntity> invoiceEntities = invoiceParkingPersistence.findAll();
        invoiceEntities.forEach(invoiceEntity -> invoice.add(modelMapper.map(invoiceEntity, Invoice.class)));

        return invoice;
    }
}
