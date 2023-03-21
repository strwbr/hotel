package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "paid_service")
@Getter
@Setter
@NoArgsConstructor
public class PaidService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "availability_status_id")
    private AvailabilityStatus availabilityStatus;
    private double price;
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
    @OneToMany(mappedBy = "paidService")
    private List<PaymentChequePaidService> paymentChequePaidServiceList;
}