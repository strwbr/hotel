package com.example.hotel.services.impl;

import com.example.hotel.model.BookingCancellation;
import com.example.hotel.repos.BookingCancellationRepository;
import com.example.hotel.services.BookingCancellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingCancellationServiceImpl implements BookingCancellationService {

    @Autowired
    private BookingCancellationRepository repository;

    @Override
    public List<BookingCancellation> getAllBookingCancellations() {
        return this.repository.findAll();
    }

    @Override
    public void saveBookingCancellation(BookingCancellation bookingCancellation) {
        this.repository.save(bookingCancellation);
    }

    @Override
    public BookingCancellation getBookingCancellationById(long id) {
        Optional<BookingCancellation> optional = this.repository.findById(id);
        BookingCancellation bookingCancellation = null;
        if(optional.isPresent())
            bookingCancellation = optional.get();
        else
            throw new RuntimeException("BookingCancellation NOT found for id : " + id);

        return bookingCancellation;
    }

    @Override
    public void deleteBookingCancellationById(long id) {
        this.repository.deleteById(id);
    }
}
