package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_type_bed_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypeBedType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    private byte bedAmount; // Кол-во спальных мест

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bed_type_id")
    private BedType bedType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}