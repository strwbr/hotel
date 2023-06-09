package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "room_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String name;
    private String description;

    @OneToMany(mappedBy = "roomType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Booking> bookingList;

    @OneToMany(mappedBy = "roomType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Room> roomList;

    @OneToMany(mappedBy = "roomType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RoomPrice> roomPriceList;

    @OneToMany(mappedBy = "roomType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RoomTypeAdditionalService> roomTypeAdditionalServiceList;

    @OneToMany(mappedBy = "roomType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RoomTypeRoomEquipment> roomTypeRoomEquipmentList;

    @OneToMany(mappedBy = "roomType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RoomTypeBedType> roomTypeBedTypeList;
}