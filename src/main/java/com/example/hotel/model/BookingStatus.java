package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "booking_status")
@Getter
@Setter
@NoArgsConstructor
public class BookingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    private String name;
    @OneToMany(mappedBy = "bookingStatus")
    private List<Booking> bookingList;
}