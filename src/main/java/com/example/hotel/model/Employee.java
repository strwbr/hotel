package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthday;
    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "residence_address_id")
    private Address residenceAddress;
    @ManyToOne
    @JoinColumn(name = "registered_address_id")
    private Address registeredAddress;
    private long docNumber;
    private long phoneNumber;
    private String email;
    private Date hireDate;
    private Date dismissalDate;
    @ManyToOne
    @JoinColumn(name = "employee_status_id")
    private EmployeeStatus employeeStatus;
    @OneToOne(mappedBy = "employee")
    User user;


}