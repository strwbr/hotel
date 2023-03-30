package com.example.hotel.services.impl;

import com.example.hotel.model.BookingExtension;
import com.example.hotel.repos.BookingExtensionRepository;
import com.example.hotel.services.BookingExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingExtensionServiceImpl implements BookingExtensionService {

    @Autowired
    private BookingExtensionRepository repository;

    @Override
    public List<BookingExtension> getAllBookingExtensions() {
        return this.repository.findAll();
    }

    @Override
    public void saveBookingExtension(BookingExtension bookingExtension) {
        this.repository.save(bookingExtension);
    }

    @Override
    public BookingExtension getBookingExtensionById(long id) {
        Optional<BookingExtension> optional = repository.findById(id);
        BookingExtension bookingExtension = null;
        if (optional.isPresent())
            bookingExtension = optional.get();
        else throw new RuntimeException("BookingExtension NOT found for id : \" + id");
        return bookingExtension;
    }

    @Override
    public void deleteBookingExtensionById(long id) {
        this.repository.deleteById(id);
    }
}
