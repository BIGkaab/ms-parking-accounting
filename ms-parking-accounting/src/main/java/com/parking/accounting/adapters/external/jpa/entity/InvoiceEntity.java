package com.parking.accounting.adapters.external.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "accounting")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer employeeId;
    private Integer spaceParkingId;
    private LocalDate issueDate;
    private String licensePlate;
    private LocalTime parkingTime;
    private BigDecimal amount;
    private BigDecimal hourlyPrice;
    private String currency;
    private String paymentType;
    private Boolean paymented;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity that = (InvoiceEntity) o;
        return id == that.id && Objects.equals(employeeId, that.employeeId) && Objects.equals(spaceParkingId, that.spaceParkingId) && Objects.equals(issueDate, that.issueDate) && Objects.equals(licensePlate, that.licensePlate) && Objects.equals(parkingTime, that.parkingTime) && Objects.equals(amount, that.amount) && Objects.equals(hourlyPrice, that.hourlyPrice) && Objects.equals(currency, that.currency) && Objects.equals(paymentType, that.paymentType) && Objects.equals(paymented, that.paymented);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, spaceParkingId, issueDate, licensePlate, parkingTime, amount, hourlyPrice, currency, paymentType, paymented);
    }
}
