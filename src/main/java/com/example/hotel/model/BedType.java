package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bed_type")
@Getter
@Setter
@NoArgsConstructor
public class BedType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "bedType")
    private List<RoomTypeBedType> roomTypeBedTypeList;
    @OneToMany(mappedBy = "bedType")
    private List<ExtraBed> extraBedList;
}