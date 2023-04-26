package com.example.hotel.controllers;

import com.example.hotel.model.AdditionalService;
import com.example.hotel.model.Booking;
import com.example.hotel.model.RoomType;
import com.example.hotel.services.AdditionalServiceService;
import com.example.hotel.services.BookingService;
import com.example.hotel.services.ClientService;
import com.example.hotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private AdditionalServiceService additionalServiceService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Booking> bookings = bookingService.getNewBookings();
        model.addAttribute("bookings", bookings);
        return "bookings-list";
    }

    @GetMapping("/info/{id}")
    private String bookingInfo(@PathVariable(value = "id") long id, Model model) {
        Booking booking = bookingService.getBookingById(id);
        model.addAttribute("booking", booking);
        return "booking-info";
    }

    @GetMapping("/add")
    private String viewAddForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());
        model.addAttribute("additionalServices", additionalServiceService.getAllAdditionalServices());
        return "booking-add";
    }

    @PostMapping("/add")
    private String addBooking(@ModelAttribute("booking") Booking booking) {

        return "redirect:/booking";
    }
}
