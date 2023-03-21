package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "departure")
@Getter
@Setter
@NoArgsConstructor
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "occupied_rom_id")
    private OccupiedRoom occupiedRoom;
    private LocalDate realDepartureDate; // Фактическая дата выезда
    private LocalTime realDepartureTime; // Фактическое время выезда
}