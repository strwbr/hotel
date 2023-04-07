package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "availability_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String name;

    @OneToMany(mappedBy = "availabilityStatus", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PaidService> paidServiceList;

    @OneToMany(mappedBy = "availabilityStatus", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AdditionalService> additionalServiceList;
}