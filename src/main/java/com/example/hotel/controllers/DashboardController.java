package com.example.hotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    private String viewPage(Model model) {

        int bookedRooms = 3;
        int availableRooms = 1;
        int clients = 3;
        int newBookings = 2;

        model.addAttribute("bookedRooms", bookedRooms);
        model.addAttribute("availableRooms", availableRooms);
        model.addAttribute("clients", clients);
        model.addAttribute("newBookings", newBookings);
        return "dashboard";
    }
}
