package com.example.hotel.services.impl;

import com.example.hotel.model.Payment;
import com.example.hotel.model.PaymentStatus;
import com.example.hotel.repos.PaymentStatusRepository;
import com.example.hotel.services.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {

    @Autowired
    private PaymentStatusRepository repository;

    @Override
    public List<PaymentStatus> getAllPaymentStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void savePaymentStatus(PaymentStatus paymentStatus) {
        this.repository.save(paymentStatus);
    }

    @Override
    public PaymentStatus getPaymentStatusById(long id) {
        Optional<PaymentStatus> optional = repository.findById(id);
        PaymentStatus paymentStatus = null;
        if (optional.isPresent())
            paymentStatus = optional.get();
        else throw new RuntimeException("PaymentStatus NOT found for id : \" + id");
        return paymentStatus;
    }

    @Override
    public void deletePaymentStatusById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public PaymentStatus getPaymentStatusByName(String name) {
        Optional<PaymentStatus> optional = repository.findByName(name);
        PaymentStatus paymentStatus = null;
        if (optional.isPresent())
            paymentStatus = optional.get();
        else throw new RuntimeException("PaymentStatus NOT found for name : " + name);
        return paymentStatus;
    }

    @Override
    public PaymentStatus getSuccessfulStatus() {
        return this.getPaymentStatusByName("Успешно");
    }
}
