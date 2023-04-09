package com.example.hotel.controllers;

import com.example.hotel.model.Client;
import com.example.hotel.model.OccupiedRoom;
import com.example.hotel.services.OccupiedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booked-room")
public class BookedRoomController {

    @Autowired
    private OccupiedRoomService occupiedRoomService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<OccupiedRoom> occupiedRooms = occupiedRoomService.getAllOccupiedRooms();
        model.addAttribute("occupiedRooms", occupiedRooms);
        return "booked-rooms-list";
    }
}
