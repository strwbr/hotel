package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "room_price")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @Min(value = 0, message = "Число должно быть больше 0")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private RoomPriceStatus status;
}