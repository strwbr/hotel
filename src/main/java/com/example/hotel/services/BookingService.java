package com.example.hotel.services;

import com.example.hotel.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    void saveBooking(Booking booking);
    Booking getBookingById(long id);
    void deleteBookingById(long id);

    // Получение завершенных или отмененных бронирований
    List<Booking> getCompletedOrCancelledBookings();
    // Получение новых бронирований (со статусами: "Подтверждено", "Требуется предоплата")
    List<Booking> getNewBookings();
    // Получение всех бронирований, отсортированных по убыванию даты оформления
    List<Booking> getAllBookingOrderByBookingTimeDesc();

    double countHotelPrice(Booking booking);
    double countPrepaymentCost(Booking booking);
    double countPaidServicesCost(Booking booking);
    double countCheckInCost(Booking booking);
    double countCheckOutCost(Booking booking);

    long countOccupationPeriod(Booking booking);
}
