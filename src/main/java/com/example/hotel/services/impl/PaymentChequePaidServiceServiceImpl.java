package com.example.hotel.services.impl;

import com.example.hotel.model.PaidService;
import com.example.hotel.model.PaymentChequePaidService;
import com.example.hotel.repos.PaymentChequePaidServiceRepository;
import com.example.hotel.services.PaymentChequePaidServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentChequePaidServiceServiceImpl implements PaymentChequePaidServiceService {

    @Autowired
    private PaymentChequePaidServiceRepository repository;

    @Override
    public List<PaymentChequePaidService> getAllPaymentChequePaidServices() {
        return this.repository.findAll();
    }

    @Override
    public void savePaymentChequePaidService(PaymentChequePaidService paymentChequePaidService) {
        this.repository.save(paymentChequePaidService);
    }

    @Override
    public PaymentChequePaidService getPaymentChequePaidServiceById(long id) {
        Optional<PaymentChequePaidService> optional = repository.findById(id);
        PaymentChequePaidService paymentChequePaidService = null;
        if (optional.isPresent())
            paymentChequePaidService = optional.get();
        else throw new RuntimeException("PaymentChequePaidService NOT found for id : \" + id");
        return paymentChequePaidService;
    }

    @Override
    public void deletePaymentChequePaidServiceById(long id) {
        this.repository.deleteById(id);
    }
}
