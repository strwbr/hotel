package com.example.hotel.services.impl;

import com.example.hotel.model.PaymentPurpose;
import com.example.hotel.model.PaymentType;
import com.example.hotel.repos.PaymentTypeRepository;
import com.example.hotel.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private PaymentTypeRepository repository;

    @Override
    public List<PaymentType> getAllPaymentTypes() {
        return this.repository.findAll();
    }

    @Override
    public void savePaymentType(PaymentType paymentType) {
        this.repository.save(paymentType);
    }

    @Override
    public PaymentType getPaymentTypeById(long id) {
        Optional<PaymentType> optional = this.repository.findById(id);
        PaymentType paymentType = null;
        if (optional.isPresent())
            paymentType = optional.get();
        else throw new RuntimeException("PaymentPurpose NOT found for id : " + id);
        return paymentType;
    }

    @Override
    public void deletePaymentTypeById(long id) {
        this.repository.deleteById(id);
    }
}
