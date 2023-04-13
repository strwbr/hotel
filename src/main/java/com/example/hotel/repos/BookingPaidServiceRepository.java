package com.example.hotel.repos;

import com.example.hotel.model.BookingPaidService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingPaidServiceRepository extends JpaRepository<BookingPaidService, Long> {
}