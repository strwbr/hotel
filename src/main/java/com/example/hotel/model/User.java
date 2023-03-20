package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String login;
    // password

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoleList;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}