package com.example.hotel.services;

import com.example.hotel.model.BookingCancellationReason;

import java.util.List;

public interface BookingCancellationReasonService {
    List<BookingCancellationReason> getAllBookingCancellationReasons();
    void saveBookingCancellationReason(BookingCancellationReason bookingCancellationReason);
    BookingCancellationReason getBookingCancellationReasonById(long id);
    void deleteBookingCancellationReasonById(long id);
}
