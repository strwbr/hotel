package com.example.hotel.repos;

import com.example.hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Поиск всех бронирований со статусом/ами statuses и сортировка по убыванию даты оформления
    @Query(value = "SELECT b.* FROM booking b JOIN booking_status bs ON b.booking_status_id = bs.id WHERE bs.name IN (:statuses) ORDER BY b.booking_time DESC",
            nativeQuery = true)
    List<Booking> findAllByStatusesOrderByBookingTimeDesc(@Param("statuses") List<String> statuses);

    // Поиск всех бронирований и сортировка по убыванию даты оформления
    @Query(value = "SELECT * FROM booking ORDER BY booking_time DESC", nativeQuery = true)
    List<Booking> findAllOrderByBookingTimeDesc();

    @Query(value = "SELECT b.* FROM booking b JOIN booking_status bs ON b.booking_status_id = bs.id WHERE bs.name IN (:statuses) AND b.id = :bookingId ORDER BY b.booking_time DESC",
    nativeQuery = true)
    List<Booking> findAllByStatusesAndIdOrderByBookingTimeDesc(@Param("statuses") List<String> statuses, @Param("bookingId") long bookingId);
}