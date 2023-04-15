package com.example.hotel.controllers;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Client;
import com.example.hotel.model.OccupiedRoom;
import com.example.hotel.services.AddressService;
import com.example.hotel.services.ClientService;
import com.example.hotel.services.OccupiedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/guest")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OccupiedRoomService occupiedRoomService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Client> clients = clientService.getAllClients();
        model.addAttribute("guests", clients);
        return "guests-list";
    }

    @GetMapping("/info/{id}")
    private String guestInfo(@PathVariable(value = "id") long id, Model model) {
        Client client = clientService.getClientById(id);

        String residenceAddress = addressService.getFullAddressString(client.getResidenceAddress().getId());
        String registeredAddress = addressService.getFullAddressString(client.getRegisteredAddress().getId());
        Iterable<OccupiedRoom> occupiedRooms = occupiedRoomService.getAllOccupiedRoomsByClientId(id);

        model.addAttribute("guest", client);
        model.addAttribute("occupiedRooms", occupiedRooms);
        model.addAttribute("residenceAddress", residenceAddress);
        model.addAttribute("registeredAddress", registeredAddress);
        model.addAttribute("status", clientService.isVIPClient(client));
        return "guest-info";
    }

}
