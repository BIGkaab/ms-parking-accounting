package com.parking.accounting.application.usescases;

import com.parking.accounting.application.port.in.GetInvoiceParkingQueryService;
import com.parking.accounting.application.port.out.InvoiceParkingRepository;
import com.parking.accounting.config.exception.InternalServerErrorException;
import com.parking.accounting.domain.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.parking.accounting.config.utils.Emun.MESSAGE_INTERNAL_SERVER_ERROR_EXCEPTION;

@Service
@AllArgsConstructor
public class GetInvoiceParkingUsesCase implements GetInvoiceParkingQueryService {

    private final InvoiceParkingRepository invoiceParkingRepository;

    @Override
    public List<Invoice> execute() {
        try{
            return invoiceParkingRepository.FindAll();
        }catch (Exception e){
            throw new InternalServerErrorException(MESSAGE_INTERNAL_SERVER_ERROR_EXCEPTION);
        }
    }
}
