package com.example.hotel.controllers;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Client;
import com.example.hotel.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Client> clients = clientService.getAllClients();
        model.addAttribute("guests", clients);
        return "guests-list";
    }
}
