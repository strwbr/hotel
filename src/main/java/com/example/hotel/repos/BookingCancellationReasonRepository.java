package com.example.hotel.repos;

import com.example.hotel.model.BookingCancellationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingCancellationReasonRepository extends JpaRepository<BookingCancellationReason, Long> {
}