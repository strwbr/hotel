package com.example.hotel.repos;

import com.example.hotel.model.PaymentPurpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentPurposeRepository extends JpaRepository<PaymentPurpose, Long> {

    @Query(value = "SELECT * FROM payment_purpose pp WHERE pp.name = :name", nativeQuery = true)
    Optional<PaymentPurpose> findByName(@Param("name") String name);
}