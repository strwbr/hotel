package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "availability_status")
@Getter
@Setter
@NoArgsConstructor
public class AvailabilityStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "availabilityStatus")
    private List<PaidService> paidServiceList;
    @OneToMany(mappedBy = "availabilityStatus")
    private List<AdditionalService> additionalServiceList;
}