package com.example.hotel.services;

import com.example.hotel.model.PaymentCheque;

import java.util.List;

public interface PaymentChequeService {
    List<PaymentCheque> getAllPaymentCheques();
    void savePaymentCheque(PaymentCheque paymentCheque);
    PaymentCheque getPaymentChequeById(long id);
    void deletePaymentChequeById(long id);
}
