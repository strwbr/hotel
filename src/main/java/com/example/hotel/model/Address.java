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
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    @Min(value = 0, message = "Число должно быть больше 0")
    private int house; // номер дома
    private String building; // строение
    @Min(value = 0, message = "Число должно быть больше 0")
    private int apartment; // квартира
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_type_id")
    private StreetType streetType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id")
    private Street street;
    @OneToMany(mappedBy = "residenceAddress", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Employee> employeesByResidentialAddressList;
    @OneToMany(mappedBy = "registeredAddress", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Employee> employeesByRegistrationAddressList;
    @OneToMany(mappedBy = "residenceAddress", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Client> clientsByResidentialAddressList;
    @OneToMany(mappedBy = "registeredAddress", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Client> clientsByRegistrationAddressList;
}