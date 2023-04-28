package com.example.hotel.repos;

import com.example.hotel.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "SELECT p.* FROM payment p\n" +
            "JOIN booking b \n" +
            "ON p.booking_id = b.id\n" +
            "JOIN payment_purpose pp\n" +
            "ON p.payment_purpose_id = pp.id\n" +
            "WHERE b.id = :bookingId\n" +
            "AND pp.name = :purposeName", nativeQuery = true)
    Optional<Payment> findByBookingIdAndPaymentPurposeName(@Param("bookingId") Long bookingId,
                                                           @Param("purposeName") String purposeName);
}