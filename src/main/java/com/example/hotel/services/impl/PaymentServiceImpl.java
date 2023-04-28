package com.example.hotel.services.impl;

import com.example.hotel.model.Payment;
import com.example.hotel.repos.PaymentRepository;
import com.example.hotel.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Payment> optional = repository.findById(id);
        Payment payment = null;
        if (optional.isPresent())
            payment = optional.get();
        else throw new RuntimeException("Payment NOT found for id : \" + id");
        return payment;
    }

    @Override
    public void deletePaymentById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Payment getPaymentByBookingIdAndPurposeName(long bookingId, String purposeName) {
        Optional<Payment> optional = repository.findByBookingIdAndPaymentPurposeName(bookingId, purposeName);
        Payment payment = null;
        if (optional.isPresent())
            payment = optional.get();
        else throw new RuntimeException("Payment NOT found for bookingId : " + bookingId + " и purposeName : " + purposeName);
        return payment;
    }
}
