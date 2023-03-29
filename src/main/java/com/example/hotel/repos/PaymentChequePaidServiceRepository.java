package com.example.hotel.repos;

import com.example.hotel.model.PaymentChequePaidService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentChequePaidServiceRepository extends JpaRepository<PaymentChequePaidService, Long> {
}