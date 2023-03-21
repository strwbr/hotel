package com.example.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthday;
    @ManyToOne
    @JoinColumn(name = "residence_address_id")
    private Address residenceAddress;
    @ManyToOne
    @JoinColumn(name = "registered_address_id")
    private Address registeredAddress;
    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;
    private long docNumber;
    private long phoneNumber;
    private String email;
    @ManyToOne
    @JoinColumn(name = "client_status_id")
    private ClientStatus clientStatus;
    @OneToMany(mappedBy = "client")
    private List<Booking> bookingList;
    @OneToMany(mappedBy = "client")
    private List<OccupiedNumber> occupiedNumberList;
}