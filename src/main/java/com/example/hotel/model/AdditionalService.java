package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "additional_service")
@Getter
@Setter
@NoArgsConstructor
public class AdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "availability_status_id")
    private AvailabilityStatus availabilityStatus;
    @OneToMany(mappedBy = "additionalService")
    private List<RoomTypeAdditionalService> roomTypeAdditionalServiceList;
}