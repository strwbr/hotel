package com.example.hotel.repos;

import com.example.hotel.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus, Long> {
    @Query(value = "SELECT * FROM booking_status bs WHERE bs.name = :name", nativeQuery = true)
    Optional<BookingStatus> findByName(@Param("name") String name);
}