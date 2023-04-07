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
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private PrepaymentStatus status;

    @OneToOne(mappedBy = "prepayment", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private BookingExtension bookingExtension;

    @OneToOne(mappedBy = "prepayment", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Booking booking;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

}