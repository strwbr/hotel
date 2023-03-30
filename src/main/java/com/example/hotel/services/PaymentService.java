package com.example.hotel.services;

import com.example.hotel.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    void savePayment(Payment payment);
    Payment getPaymentById(long id);
    void deletePaymentById(long id);
}
