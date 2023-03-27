package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_type_room_equipment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypeRoomEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "room_equipment_id")
    private RoomEquipment roomEquipment;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}