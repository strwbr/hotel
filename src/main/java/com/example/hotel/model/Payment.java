package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private double amount; // Сумма к оплате
    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;
    @ManyToOne
    @JoinColumn(name = "payment_status_id")
    private PaymentStatus paymentStatus;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    @OneToOne(mappedBy = "payment")
    private PaymentCheque paymentCheque;
    @OneToOne(mappedBy = "payment")
    private Prepayment prepayment;
}