package com.example.hotel.services.impl;

import com.example.hotel.model.Booking;
import com.example.hotel.model.PaymentPurpose;
import com.example.hotel.repos.PaymentPurposeRepository;
import com.example.hotel.services.PaymentPurposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentPurposeServiceImpl implements PaymentPurposeService {

    @Autowired
    private PaymentPurposeRepository repository;

    @Override
    public List<PaymentPurpose> getAllPaymentPurpose() {
        return this.repository.findAll();
    }

    @Override
    public void savePaymentPurpose(PaymentPurpose paymentPurpose) {
        this.repository.save(paymentPurpose);
    }

    @Override
    public PaymentPurpose getPaymentPurposeById(long id) {
        Optional<PaymentPurpose> optional = repository.findById(id);
        PaymentPurpose paymentPurpose = null;
        if (optional.isPresent())
            paymentPurpose = optional.get();
        else throw new RuntimeException("PaymentPurpose NOT found for id : " + id);
        return paymentPurpose;
    }

    @Override
    public void deletePaymentPurposeById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public PaymentPurpose getPaymentPurposeByName(String name) {
        Optional<PaymentPurpose> optional = repository.findByName(name);
        PaymentPurpose paymentPurpose = null;
        if (optional.isPresent())
            paymentPurpose = optional.get();
        else throw new RuntimeException("PaymentPurpose NOT found for name : " + name);
        return paymentPurpose;
    }

    @Override
    public PaymentPurpose getPaymentPurposeForPrepayment() {
        return this.getPaymentPurposeByName("Предоплата");
    }

    @Override
    public PaymentPurpose getPaymentPurposeForArrival() {
        return this.getPaymentPurposeByName("При въезде");
    }

    @Override
    public PaymentPurpose getPaymentPurposeForDeparture() {
        return this.getPaymentPurposeByName("При выезде");
    }
}
