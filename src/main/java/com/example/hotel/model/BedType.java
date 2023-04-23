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
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String name;
//    TODO добавить поле в БД
//    private byte capacity;

    @OneToMany(mappedBy = "bedType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RoomTypeBedType> roomTypeBedTypeList;

    @OneToMany(mappedBy = "bedType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExtraBed> extraBedList;
}