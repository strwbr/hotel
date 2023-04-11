package com.example.hotel.controllers;

import com.example.hotel.model.Booking;
import com.example.hotel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/archived-booking")
public class ArchivedBookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Booking> archivedBookings = this.bookingService.getCompletedOrCancelledBookings();
        model.addAttribute("archivedBookings", archivedBookings);
        return "archived-booking-list";
    }
}
