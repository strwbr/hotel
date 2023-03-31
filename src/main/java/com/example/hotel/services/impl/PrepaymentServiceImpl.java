package com.example.hotel.services.impl;

import com.example.hotel.model.PaymentStatus;
import com.example.hotel.model.Prepayment;
import com.example.hotel.repos.PrepaymentRepository;
import com.example.hotel.services.PrepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrepaymentServiceImpl implements PrepaymentService {

    @Autowired
    private PrepaymentRepository repository;

    @Override
    public List<Prepayment> getAllPrepayments() {
        return this.repository.findAll();
    }

    @Override
    public void savePrepayment(Prepayment prepayment) {
        this.repository.save(prepayment);
    }

    @Override
    public Prepayment getPrepaymentById(long id) {
        Optional<Prepayment> optional = repository.findById(id);
        Prepayment prepayment = null;
        if (optional.isPresent())
            prepayment = optional.get();
        else throw new RuntimeException("Prepayment NOT found for id : \" + id");
        return prepayment;
    }

    @Override
    public void deletePrepaymentById(long id) {
        this.repository.deleteById(id);
    }
}
