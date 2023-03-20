package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int house; // номер дома
    private int building; // строение
    private int apartment; // квартира
    @ManyToOne
    @JoinColumn(name = "street_type_id")
    private StreetType streetType;
    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;
    @OneToMany(mappedBy = "residenceAddress")
    List<Employee> employeesByResidentialAddressList;
    @OneToMany(mappedBy = "registeredAddress")
    List<Employee> employeesByRegistrationAddressList;
}