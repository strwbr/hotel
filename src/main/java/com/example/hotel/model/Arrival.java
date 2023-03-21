package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "arrival")
@Getter
@Setter
@NoArgsConstructor
public class Arrival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    private LocalDate realArrivalDate; // Фактическая дата заезда
    private LocalTime realArrivalTime; // Фактическое время заезда
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "occupied_rom_id")
    private OccupiedRoom occupiedRoom;

}