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
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String login;
    // password

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoleList;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}