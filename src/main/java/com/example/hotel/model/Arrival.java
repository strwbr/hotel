package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Arrival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    private LocalDate realArrivalDate; // Фактическая дата заезда
    private LocalTime realArrivalTime; // Фактическое время заезда

    @OneToOne
    @JoinColumn(name = "occupied_rom_id")
    private OccupiedRoom occupiedRoom;
}