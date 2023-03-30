package com.example.hotel.services.impl;

import com.example.hotel.model.PaymentChequePaidService;
import com.example.hotel.repos.PaymentChequePaidServiceRepository;
import com.example.hotel.services.PaymentChequePaidServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deletePaymentChequePaidServiceById(long id) {
        this.repository.deleteById(id);
    }
}
