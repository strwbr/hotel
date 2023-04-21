package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "residence_address_id")
    private Address residenceAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registered_address_id")
    private Address registeredAddress;

    @Min(value = 0, message = "Число должно быть больше 0")
    private long docNumber;
    @Min(value = 0, message = "Число должно быть больше 0")
    private long phoneNumber;
    @Email
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate; // Дата найма
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dismissalDate; // Дата увольнения

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_status_id")
    private EmployeeStatus employeeStatus;

    @OneToOne(mappedBy = "employee", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Payment> paymentList;
}