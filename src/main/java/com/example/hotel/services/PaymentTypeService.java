package com.example.hotel.services;

import com.example.hotel.model.PaymentPurpose;
import com.example.hotel.model.PaymentType;

import java.util.List;

public interface PaymentTypeService {
    List<PaymentType> getAllPaymentTypes();
    void savePaymentType(PaymentType paymentType);
    PaymentType getPaymentTypeById(long id);
    void deletePaymentTypeById(long id);
}
