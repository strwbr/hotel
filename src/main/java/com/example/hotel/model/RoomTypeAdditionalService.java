package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_type_additional_service")
@Getter
@Setter
@NoArgsConstructor
public class RoomTypeAdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    @ManyToOne
    @JoinColumn(name = "additional_service_id")
    private AdditionalService additionalService;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}