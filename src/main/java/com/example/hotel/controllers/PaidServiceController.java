package com.example.hotel.controllers;

import com.example.hotel.model.PaidService;
import com.example.hotel.services.PaidServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paid-service")
public class PaidServiceController {

    @Autowired
    private PaidServiceService paidServiceService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<PaidService> paidServices = paidServiceService.getAllPaidServices();
        model.addAttribute("paidServices", paidServices);
        return "paid-services-list";
    }
}
