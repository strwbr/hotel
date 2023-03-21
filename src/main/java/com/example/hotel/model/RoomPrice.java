package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "room_price")
@Getter
@Setter
@NoArgsConstructor
public class RoomPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    private Date startDate;
    private Date endDate;
    private double price;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private RoomPriceStatus status;
}