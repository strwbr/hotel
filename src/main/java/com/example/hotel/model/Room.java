package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String number; // Числовое обозначение номера (мб в int)
    @OneToMany(mappedBy = "room")
    private List<OccupiedRoom> occupiedRoomList;

    @ManyToOne
    @JoinColumn(name = "room_status_id")
    private RoomStatus roomStatus;

    @ManyToOne
    @JoinColumn(name = "cleaning_status_id")
    private CleaningStatus cleaningStatus;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

}