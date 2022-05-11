package com.parking.accounting.adapters.external.jpa.entity;

import lombok.*;

import javax.persistence.*;
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

    @Column(nullable = false)
    private Integer employeeId;

    @Column(nullable = false)
    private Integer spaceParkingId;

    @Column(nullable = false)
    private String issueDate;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private Double parkingTime;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double hourlyPrice;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String paymentType;

    private Boolean paymented;
}
