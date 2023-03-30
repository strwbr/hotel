package com.example.hotel.services.impl;

import com.example.hotel.model.Payment;
import com.example.hotel.repos.PaymentRepository;
import com.example.hotel.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public List<Payment> getAllPayments() {
        return this.repository.findAll();
    }

    @Override
    public void savePayment(Payment payment) {
        this.repository.save(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return null;
    }

    @Override
    public void deletePaymentById(long id) {
        this.repository.deleteById(id);
    }
}
