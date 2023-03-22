package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "id")
    @NotNull
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
    @Min(value = 0, message = "Число должно быть больше 0")
    private long docNumber;
    @Min(value = 0, message = "Число должно быть больше 0")
    private long phoneNumber;
    @Email
    private String email;
    private Date hireDate; // Дата найма
    private Date dismissalDate; // Дата увольнения
    @ManyToOne
    @JoinColumn(name = "employee_status_id")
    private EmployeeStatus employeeStatus;
    @OneToOne(mappedBy = "employee")
    private User user;
    @OneToMany(mappedBy = "employee")
    private List<PaymentCheque> paymentChequeList;
}