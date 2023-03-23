package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "payment_cheque")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @OneToMany(mappedBy = "paymentCheque")
    private List<PaymentChequePaidService> paymentChequePaidServiceList;
}