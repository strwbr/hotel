package com.example.hotel.repos;

import com.example.hotel.model.Prepayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrepaymentRepository extends JpaRepository<Prepayment, Long> {
}