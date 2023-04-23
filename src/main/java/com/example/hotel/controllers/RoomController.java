package com.example.hotel.controllers;

import com.example.hotel.model.Room;
import com.example.hotel.services.RoomService;
import com.example.hotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "rooms-list";
    }

    @GetMapping("/add")
    private String viewAddForm(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());
        return "room-add";
    }

    @PostMapping("/add")
    private String addRoom(@ModelAttribute("room") Room room) {
        // TODO проверка на то, что room.number уже есть
        roomService.saveRoom(room);
        return "redirect:/room";
    }
}
