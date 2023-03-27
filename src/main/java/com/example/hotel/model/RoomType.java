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
    private byte baseCapacity; // Базовая вместимость
    private byte maxCapacity; // Максимальная вместимость (с учетом доп.кровати/ей)
    @Min(value = 0, message = "Число должно быть больше 0")
    private double price; // Цена за сутки проживания
    @OneToMany(mappedBy = "roomType")
    private List<Booking> bookingList;
    @OneToMany(mappedBy = "roomType")
    private List<Room> roomList;
    @OneToMany(mappedBy = "roomType")
    private List<RoomPrice> roomPriceList;
    @OneToMany(mappedBy = "roomType")
    private List<RoomTypeAdditionalService> roomTypeAdditionalServiceList;
    @OneToMany(mappedBy = "roomType")
    private List<RoomTypeRoomEquipment> roomTypeRoomEquipmentList;
    @OneToMany(mappedBy = "roomType")
    private List<RoomTypeBedType> roomTypeBedTypeList;
    @OneToMany(mappedBy = "roomType")
    private List<RoomTypeExtraBed> roomTypeExtraBedList;
}