package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "prepayment_id")
    private Prepayment prepayment;
    @ManyToOne
    @JoinColumn(name = "booking_status_id")
    private BookingStatus bookingStatus;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    @Min(value = 0, message = "Число должно быть больше 0")
    private byte roomsAmount; // Кол-во номеров
    private LocalDateTime bookingTime; // Дата и время оформления бронирования TODO
    private Date checkInDate; // Дата заезда
    private Date checkOutDate; // Дата выезда
    @Min(value = 0, message = "Число должно быть больше 0")
    private byte adultsAmount; // Кол-во взрослых
    @Min(value = 0, message = "Число должно быть больше 0")
    private byte childrenAmount; // Кол-во детей
    private double totalCost; // Общая стоимость
    @OneToMany(mappedBy = "booking")
    private List<BookingCancellation> bookingCancellationList;
    @OneToMany(mappedBy = "booking")
    private List<OccupiedRoom> occupiedRoomList;
    @OneToMany(mappedBy = "booking")
    private List<BookingExtension> bookingExtensionList;




}