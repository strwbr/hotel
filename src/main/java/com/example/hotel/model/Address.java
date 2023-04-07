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

    @OneToMany(mappedBy = "residenceAddress", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employee> employeesByResidentialAddressList;

    @OneToMany(mappedBy = "registeredAddress", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employee> employeesByRegistrationAddressList;

    @OneToMany(mappedBy = "residenceAddress", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Client> clientsByResidentialAddressList;

    @OneToMany(mappedBy = "registeredAddress", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Client> clientsByRegistrationAddressList;

    // Методы синхронизаций
    public void addEmployeeByResidentialAddress(Employee employee) {
        this.employeesByResidentialAddressList.add(employee);
        employee.setResidenceAddress(this);
    }

    public void removeEmployeeByResidentialAddress(Employee employee) {
        this.employeesByResidentialAddressList.remove(employee);
        employee.setResidenceAddress(null);
    }

    public void addEmployeeByRegistrationAddress(Employee employee) {
        this.employeesByRegistrationAddressList.add(employee);
        employee.setRegisteredAddress(this);
    }

    public void removeEmployeeByRegistrationAddress(Employee employee) {
        this.employeesByRegistrationAddressList.remove(employee);
        employee.setRegisteredAddress(null);
    }

    public void addClientByResidentialAddress(Client client) {
        this.clientsByResidentialAddressList.add(client);
        client.setResidenceAddress(this);
    }

    public void removeClientByResidentialAddress(Client client) {
        this.clientsByResidentialAddressList.remove(client);
        client.setResidenceAddress(null);
    }

    public void addClientByRegistrationAddress(Client client) {
        this.clientsByRegistrationAddressList.add(client);
        client.setRegisteredAddress(this);
    }

    public void removeClientByRegistrationAddress(Client client) {
        this.clientsByRegistrationAddressList.remove(client);
        client.setRegisteredAddress(null);
    }
}