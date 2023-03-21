package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_type_bed_type")
@Getter
@Setter
@NoArgsConstructor
public class RoomTypeBedType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private byte bedAmount; // Кол-во спальных мест
    @ManyToOne
    @JoinColumn(name = "bed_type_id")
    private BedType bedType;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}