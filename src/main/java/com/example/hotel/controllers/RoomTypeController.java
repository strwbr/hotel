package com.example.hotel.controllers;

import com.example.hotel.model.RoomType;
import com.example.hotel.services.impl.RoomTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomTypeController {
    @Autowired
    private RoomTypeServiceImpl roomTypeService;

    @GetMapping("/room_type")
    private String viewList(Model model) {
        Iterable<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        model.addAttribute("roomTypesList",
                roomTypes);
        model.addAttribute("count", 0);
        return "room-types-list";
    }

    @GetMapping("/room_type/add")
    private String roomTypeAdd(Model model) {
        return "room-type-add";
    }
}
