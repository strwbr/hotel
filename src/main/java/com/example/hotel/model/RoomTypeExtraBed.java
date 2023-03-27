package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_type_extra_bed")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypeExtraBed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    private byte amount;
    @ManyToOne
    @JoinColumn(name = "extra_bed_id")
    private ExtraBed extraBed;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}