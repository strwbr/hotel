package com.example.hotel.services;

import com.example.hotel.model.PaymentStatus;

import java.util.List;

public interface PaymentStatusService {
    List<PaymentStatus> getAllPaymentStatuses();
    void savePaymentStatus(PaymentStatus paymentStatus);
    PaymentStatus getPaymentStatusById(long id);
    void deletePaymentStatusById(long id);

    PaymentStatus getPaymentStatusByName(String name);
    PaymentStatus getSuccessfulStatus();
}
