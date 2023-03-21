package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "room_equipment")
@Getter
@Setter
@NoArgsConstructor
public class RoomEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "roomEquipment")
    private List<RoomTypeRoomEquipment> roomTypeRoomEquipmentList;
}