package com.parking.accounting.adapters.external.jpa.adapter;

import com.parking.accounting.adapters.external.jpa.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface InvoiceParkingPersistence extends JpaRepository<InvoiceEntity, Integer>{
}
