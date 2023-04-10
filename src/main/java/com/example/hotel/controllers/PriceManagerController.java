package com.example.hotel.controllers;

import com.example.hotel.model.RoomPrice;
import com.example.hotel.services.RoomPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/price-manager")
public class PriceManagerController {

    @Autowired
    private RoomPriceService roomPriceService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<RoomPrice> roomPrices = roomPriceService.getAllRoomPrices();
        model.addAttribute("roomPrices", roomPrices);
        return "price-manager-list";
    }
}
