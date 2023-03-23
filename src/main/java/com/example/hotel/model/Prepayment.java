package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prepayment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prepayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private PrepaymentStatus status;

    @OneToOne(mappedBy = "prepayment")
    private BookingExtension bookingExtension;
    @OneToOne(mappedBy = "prepayment")
    private Booking booking;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private Payment payment;

}