package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking_paid_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingPaidService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paid_service_id")
    private PaidService paidService;

    public BookingPaidService(Booking booking, PaidService paidService) {
        this.booking = booking;
        this.paidService = paidService;
    }
}