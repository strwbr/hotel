package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "occupied_room")
@Getter
@Setter
@NoArgsConstructor
public class OccupiedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    @OneToOne(mappedBy = "occupiedRoom")
    private Arrival arrival;
    @OneToOne(mappedBy = "occupiedRoom")
    private Departure departure;
}