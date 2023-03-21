package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_cheque_paid_service")
@Getter
@Setter
@NoArgsConstructor
public class PaymentChequePaidService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "paid_service_id")
    private PaidService paidService;
    @ManyToOne
    @JoinColumn(name = "payment_cheque_id")
    private PaymentCheque paymentCheque;

}