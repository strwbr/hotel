package com.example.hotel.services.impl;

import com.example.hotel.model.PaymentCheque;
import com.example.hotel.repos.PaymentChequeRepository;
import com.example.hotel.services.PaymentChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentChequeServiceImpl implements PaymentChequeService {

    @Autowired
    private PaymentChequeRepository repository;

    @Override
    public List<PaymentCheque> getAllPaymentCheques() {
        return this.repository.findAll();
    }

    @Override
    public void savePaymentCheque(PaymentCheque paymentCheque) {
        this.repository.save(paymentCheque);
    }

    @Override
    public PaymentCheque getPaymentChequeById(long id) {
        return null;
    }

    @Override
    public void deletePaymentChequeById(long id) {
        this.repository.deleteById(id);
    }
}
