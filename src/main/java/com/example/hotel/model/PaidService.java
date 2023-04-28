package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "paid_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaidService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "availability_status_id")
    private AvailabilityStatus availabilityStatus;

    @Min(value = 0, message = "Число должно быть больше 0")
    private double price;

    // TODO удалить таблицу Unit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @OneToMany(mappedBy = "paidService", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<BookingPaidService> bookingPaidServiceList;
}