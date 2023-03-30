package com.example.hotel.services;

import com.example.hotel.model.PaymentChequePaidService;

import java.util.List;

public interface PaymentChequePaidServiceService {
    List<PaymentChequePaidService> getAllPaymentChequePaidServices();
    void savePaymentChequePaidService(PaymentChequePaidService paymentChequePaidService);
    PaymentChequePaidService getPaymentChequePaidServiceById(long id);
    void deletePaymentChequePaidServiceById(long id);
}
