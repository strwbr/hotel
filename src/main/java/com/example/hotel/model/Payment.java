package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @NotNull
    private Long id;
    private double amount; // Сумма к оплате
    private Date paymentDate; // Время оплаты

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_status_id")
    private PaymentStatus paymentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_purpose_id")
    private PaymentPurpose purpose;

    public Payment(double amount, Date paymentDate, Booking booking, Employee employee, PaymentType paymentType, PaymentStatus paymentStatus, PaymentPurpose purpose) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.booking = booking;
        this.employee = employee;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.purpose = purpose;
    }

    public Payment(double amount, Booking booking, PaymentPurpose purpose) {
        this.amount = amount;
        this.booking = booking;
        this.purpose = purpose;
    }
}