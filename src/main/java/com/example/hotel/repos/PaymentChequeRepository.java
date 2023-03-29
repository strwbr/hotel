package com.example.hotel.repos;

import com.example.hotel.model.PaymentCheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentChequeRepository extends JpaRepository<PaymentCheque, Long> {
}