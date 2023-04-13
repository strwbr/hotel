package com.example.hotel.controllers;

import com.example.hotel.model.Booking;
import com.example.hotel.model.RoomType;
import com.example.hotel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Booking> bookings = bookingService.getNewBookings();
        model.addAttribute("bookings", bookings);
        return "bookings-list";
    }
}
