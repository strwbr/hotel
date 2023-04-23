package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_type_additional_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypeAdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "additional_service_id")
    private AdditionalService additionalService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    public RoomTypeAdditionalService(AdditionalService additionalService, RoomType roomType) {
        this.additionalService = additionalService;
        this.roomType = roomType;
    }
}