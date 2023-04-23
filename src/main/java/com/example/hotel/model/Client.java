package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String surname;
    @NotBlank(message = "Строка должна быть не пустая!")
    private String name;
    private String patronymic;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "residence_address_id")
    private Address residenceAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registered_address_id")
    private Address registeredAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @NotBlank(message = "Строка должна быть не пустая!")
    private String docNumber;
    @Min(value = 0, message = "Число должно быть больше 0")
    private long phoneNumber;
    @Email
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_status_id")
    private ClientStatus clientStatus;

    @OneToMany(mappedBy = "client",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Booking> bookingList;

    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<OccupiedRoomClient> occupiedRoomClientList;
}