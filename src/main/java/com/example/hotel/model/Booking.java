package com.example.hotel.model;

import jakarta.persistence.*;
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
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private byte roomsAmount; // Кол-во номеров
    private LocalDateTime bookingTime; // Дата и время оформления бронирования TODO
    private Date checkInDate; // Дата заезда
    private Date checkOutDate; // Дата выезда
    private byte adultsAmount; // Кол-во взрослых
    private byte childrenAmount; // Кол-во детей
    private double totalCost; // Общая стоимость
    @OneToMany(mappedBy = "booking")
    private List<BookingCancellation> bookingCancellationList;
    @OneToMany(mappedBy = "booking")
    private List<OccupiedNumber> occupiedNumberList;
    @OneToMany(mappedBy = "booking")
    private List<BookingExtension> bookingExtensionList;
}