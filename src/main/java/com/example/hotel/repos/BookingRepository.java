package com.example.hotel.repos;

import com.example.hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT b.* FROM booking b JOIN booking_status bs ON b.booking_status_id = bs.id WHERE bs.name IN (:statuses)",
            nativeQuery = true)
    List<Booking> findBookingsByStatuses(@Param("statuses") List<String> statuses);
}