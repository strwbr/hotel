package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "booking_extension")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;
    @OneToOne
    @JoinColumn(name = "prepayment_id")
    private Prepayment prepayment;
    private Date newCheckOutDate;
    private LocalDateTime bookingExtensionTime; // Дата оформления продления
}