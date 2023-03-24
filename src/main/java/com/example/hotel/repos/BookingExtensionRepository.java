package com.example.hotel.repos;

import com.example.hotel.model.BookingExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingExtensionRepository extends JpaRepository<BookingExtension, Long> {
}