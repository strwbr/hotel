package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "extra_bed")
@Getter
@Setter
@NoArgsConstructor
public class ExtraBed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    private double price;
    @OneToMany(mappedBy = "extraBed")
    private List<RoomTypeExtraBed> roomTypeExtraBedList;
    @ManyToOne
    @JoinColumn(name = "bed_type_id")
    private BedType bedType;
}