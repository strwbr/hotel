package com.example.hotel.controllers;

import com.example.hotel.model.Room;
import com.example.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "rooms-list";
    }
}
