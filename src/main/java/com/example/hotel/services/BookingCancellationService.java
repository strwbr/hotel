package com.example.hotel.services;

import com.example.hotel.model.BookingCancellation;

import java.util.List;

public interface BookingCancellationService {
    List<BookingCancellation> getAllBookingCancellations();
    void saveBookingCancellation(BookingCancellation bookingCancellation);
    BookingCancellation getBookingCancellationById(long id);
    void deleteBookingCancellationById(long id);
}
