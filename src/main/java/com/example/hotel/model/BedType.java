package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bed_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BedType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String name;
    @OneToMany(mappedBy = "bedType")
    private List<RoomTypeBedType> roomTypeBedTypeList;
    @OneToMany(mappedBy = "bedType")
    private List<ExtraBed> extraBedList;
}