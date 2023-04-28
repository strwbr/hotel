package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "payment_purpose")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPurpose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String name;

    @OneToMany(mappedBy = "purpose", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<Payment> paymentList;
}