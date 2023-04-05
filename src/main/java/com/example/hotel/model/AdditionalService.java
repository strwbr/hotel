package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Table(name = "additional_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNullу мен
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "availability_status_id")
    private AvailabilityStatus availabilityStatus;
    @OneToMany(mappedBy = "additionalService", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RoomTypeAdditionalService> roomTypeAdditionalServiceList;

    public AdditionalService(String name, String description, AvailabilityStatus availabilityStatus, List<RoomTypeAdditionalService> roomTypeAdditionalServiceList) {
        this.name = name;
        this.description = description;
        this.availabilityStatus = availabilityStatus;
        this.roomTypeAdditionalServiceList = roomTypeAdditionalServiceList;
    }
}