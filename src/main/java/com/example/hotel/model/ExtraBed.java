package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "extra_bed")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtraBed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    @Min(value = 0, message = "Число должно быть больше 0")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bed_type_id")
    private BedType bedType;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public ExtraBed(BedType bedType, Booking booking) {
        this.price = 1800;
        this.bedType = bedType;
        this.booking = booking;
    }
}