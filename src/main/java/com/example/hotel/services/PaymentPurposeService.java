package com.example.hotel.services;

import com.example.hotel.model.PaymentPurpose;

import java.util.List;

public interface PaymentPurposeService {
    List<PaymentPurpose> getAllPaymentPurpose();
    void savePaymentPurpose(PaymentPurpose paymentPurpose);
    PaymentPurpose getPaymentPurposeById(long id);
    void deletePaymentPurposeById(long id);

    PaymentPurpose getPaymentPurposeByName(String name);
    PaymentPurpose getPaymentPurposeForPrepayment();
    PaymentPurpose getPaymentPurposeForArrival();
    PaymentPurpose getPaymentPurposeForDeparture();
}
