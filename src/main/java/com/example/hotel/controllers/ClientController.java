package com.example.hotel.controllers;

import com.example.hotel.model.Address;
import com.example.hotel.model.Booking;
import com.example.hotel.model.Client;
import com.example.hotel.model.OccupiedRoom;
import com.example.hotel.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guest")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OccupiedRoomService occupiedRoomService;
    @Autowired
    private DocumentTypeService documentTypeService;
    @Autowired
    private ClientStatusService clientStatusService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StreetService streetService;
    @Autowired
    private StreetTypeService streetTypeService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Client> clients = clientService.getAllOrderedClients();
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

    @GetMapping("/add")
    private String viewAddForm(Model model) {
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("regions", regionService.getAllRegions());
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("streets", streetService.getAllStreets());
        model.addAttribute("streetTypes", streetTypeService.getAllStreetTypes());
        model.addAttribute("docTypes", documentTypeService.getAllDocumentTypes());

        model.addAttribute("guest", new Client());
        return "guest-add";
    }

    @PostMapping("/add")
    private String addGuest(@ModelAttribute("guest") Client client,
                            @RequestParam(value = "isVipClient", required = false) boolean isVipClient) {
        // TODO временная заглушка адреса
        Address address = addressService.getAddressById(2);
        client.setResidenceAddress(address);
        client.setRegisteredAddress(address);
        client.setClientStatus(
                (isVipClient)
                        ? clientStatusService.getVipStatus()
                        : clientStatusService.getDefaultStatus()
        );

        clientService.saveClient(client);
        return "redirect:/guest";
    }
}
