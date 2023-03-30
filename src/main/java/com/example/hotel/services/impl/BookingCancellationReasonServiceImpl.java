package com.example.hotel.services.impl;

import com.example.hotel.model.BookingCancellation;
import com.example.hotel.model.BookingCancellationReason;
import com.example.hotel.repos.BookingCancellationReasonRepository;
import com.example.hotel.services.BookingCancellationReasonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookingCancellationReasonServiceImpl implements BookingCancellationReasonService {

    @Autowired
    private BookingCancellationReasonRepository repository;

    @Override
    public List<BookingCancellationReason> getAllBookingCancellationReasons() {
        return this.repository.findAll();
    }

    @Override
    public void saveBookingCancellationReason(BookingCancellationReason bookingCancellationReason) {
        this.repository.save(bookingCancellationReason);
    }

    @Override
    public BookingCancellationReason getBookingCancellationReasonById(long id) {
        Optional<BookingCancellationReason> optionalReason =
                repository.findById(id);
        BookingCancellationReason reason = null;
        if(optionalReason.isPresent())
            reason = optionalReason.get();
        else
            throw new RuntimeException("BookingCancellationReason NOT found for id : " + id);

        return reason;
    }

    @Override
    public void deleteBookingCancellationReasonById(long id) {
        this.repository.deleteById(id);
    }
}
