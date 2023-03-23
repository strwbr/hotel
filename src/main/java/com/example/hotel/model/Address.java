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
    @Column(name = "id")
    @NotNull
    private Long id;
    @Min(value = 0, message = "Число должно быть больше 0")
    private int house; // номер дома
    private String building; // строение
    @Min(value = 0, message = "Число должно быть больше 0")
    private int apartment; // квартира
    @ManyToOne
    @JoinColumn(name = "street_type_id")
    private StreetType streetType;
    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;
    @OneToMany(mappedBy = "residenceAddress")
    private List<Employee> employeesByResidentialAddressList;
    @OneToMany(mappedBy = "registeredAddress")
    private List<Employee> employeesByRegistrationAddressList;
    @OneToMany(mappedBy = "residenceAddress")
    private List<Client> clientsByResidentialAddressList;
    @OneToMany(mappedBy = "registeredAddress")
    private List<Client> clientsByRegistrationAddressList;
}