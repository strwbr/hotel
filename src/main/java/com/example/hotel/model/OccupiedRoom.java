package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "occupied_room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OccupiedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @OneToOne(mappedBy = "occupiedRoom", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Arrival arrival;

    @OneToOne(mappedBy = "occupiedRoom", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Departure departure;
}