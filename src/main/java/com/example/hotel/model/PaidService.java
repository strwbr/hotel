package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "id")
    @NotNull
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "availability_status_id")
    private AvailabilityStatus availabilityStatus;
    @Min(value = 0, message = "Число должно быть больше 0")
    private double price;
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
    @OneToMany(mappedBy = "paidService")
    private List<PaymentChequePaidService> paymentChequePaidServiceList;
}