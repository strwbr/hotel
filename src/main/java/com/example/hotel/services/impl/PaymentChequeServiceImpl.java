package com.example.hotel.services.impl;

import com.example.hotel.model.PaymentCheque;
import com.example.hotel.model.PaymentChequePaidService;
import com.example.hotel.repos.PaymentChequeRepository;
import com.example.hotel.services.PaymentChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<PaymentCheque> optional = repository.findById(id);
        PaymentCheque paymentCheque = null;
        if (optional.isPresent())
            paymentCheque = optional.get();
        else throw new RuntimeException("PaymentCheque NOT found for id : \" + id");
        return paymentCheque;
    }

    @Override
    public void deletePaymentChequeById(long id) {
        this.repository.deleteById(id);
    }
}
