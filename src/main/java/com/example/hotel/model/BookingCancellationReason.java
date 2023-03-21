package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "booking_cancellation_reason")
@Getter
@Setter
@NoArgsConstructor
public class BookingCancellationReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "reason")
    private List<BookingCancellation> bookingCancellationList;
}