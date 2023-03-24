package com.example.hotel.repos;

import com.example.hotel.model.BookingCancellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingCancellationRepository extends JpaRepository<BookingCancellation, Long> {
}