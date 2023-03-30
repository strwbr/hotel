package com.example.hotel.services.impl;

import com.example.hotel.model.PaymentStatus;
import com.example.hotel.repos.PaymentStatusRepository;
import com.example.hotel.services.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deletePaymentStatusById(long id) {
        this.repository.deleteById(id);
    }
}
