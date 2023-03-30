package com.example.hotel.services;

import com.example.hotel.model.Prepayment;

import java.util.List;

public interface PrepaymentService {
    List<Prepayment> getAllPrepayments();
    void savePrepayment(Prepayment prepayment);
    Prepayment getPrepaymentById(long id);
    void deletePrepaymentById(long id);
}
