package com.example.hotel.repos;

import com.example.hotel.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {

    @Query(value = "SELECT * FROM payment_status ps WHERE ps.name = :name", nativeQuery = true)
    Optional<PaymentStatus> findByName(@Param("name") String name);
}