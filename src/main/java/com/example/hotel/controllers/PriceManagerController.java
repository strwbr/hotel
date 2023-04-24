package com.example.hotel.controllers;

import com.example.hotel.model.RoomPrice;
import com.example.hotel.model.RoomPriceStatus;
import com.example.hotel.model.RoomType;
import com.example.hotel.services.RoomPriceService;
import com.example.hotel.services.RoomPriceStatusService;
import com.example.hotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/price_manager")
public class PriceManagerController {

    @Autowired
    private RoomPriceService roomPriceService;
    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private RoomPriceStatusService roomPriceStatusService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<RoomPrice> roomPrices = roomPriceService.getAllRoomPrices();
        model.addAttribute("roomPrices", roomPrices);
        return "price-manager-list";
    }

    @GetMapping("/add")
    private String viewAddForm(Model model) {
        model.addAttribute("newPrice", new RoomPrice());
        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());
//        model.addAttribute("roomPriceStatuses", roomPriceStatusService.getAllRoomPriceStatuses());
        return "price-manager-add";
    }

    @PostMapping("/add")
    private String addPriceManager(@ModelAttribute("newPrice") RoomPrice newPrice) {
        RoomType roomType = newPrice.getRoomType();
        RoomPrice actualPrice = roomPriceService.getActualRoomPrice(roomType);
        RoomPriceStatus actualStatus = roomPriceStatusService.getActualStatus();
        RoomPriceStatus expiredStatus = roomPriceStatusService.getExpiredStatus();
        RoomPriceStatus awaitingStatus = roomPriceStatusService.getAwaitingStatus();
        if (actualPrice != null) {
            int compareDate = newPrice.getStartDate().compareTo(actualPrice.getEndDate());
            // Если у новой цены дата начала раньше, чем дата окончания у актуальной
            if (compareDate < 0) {
                actualPrice.setStatus(expiredStatus);
                newPrice.setStatus(actualStatus);
            } else if (compareDate > 0) {
                newPrice.setStatus(awaitingStatus);
            } else {
                // TODO compareDate == 0 нужно обработать как-то (по идее должно выдаваться предупреждение юзеру)
            }
        } else {
            newPrice.setStatus(actualStatus);
        }

        roomPriceService.saveRoomPrice(newPrice);
        roomPriceService.saveRoomPrice(actualPrice);
        return "redirect:/price_manager";
    }

    // TODO НЕ проверено (дай бог работает)
    @GetMapping("/setup_status/{id}")
    private String setupStatus(@PathVariable(value = "id") long id, Model model) {
        RoomPrice roomPrice = roomPriceService.getRoomPriceById(id);
        RoomType roomType = roomPrice.getRoomType();

        RoomPriceStatus actualStatus = roomPriceStatusService.getActualStatus();
        RoomPriceStatus expiredStatus = roomPriceStatusService.getExpiredStatus();
        RoomPriceStatus awaitingStatus = roomPriceStatusService.getAwaitingStatus();

        // TODO обработать когда нажимают на кнопку раньше по дате чем startDate
/*        if (roomPrice.getStartDate().compareTo(new Date()) >= 0) {
            return "redirect:/price_manager";
        }*/

        RoomPrice actualPrice = roomPriceService.getActualRoomPrice(roomType);
        int compareDate = roomPrice.getStartDate().compareTo(actualPrice.getEndDate());
        if (compareDate < 0) {
            actualPrice.setStatus(expiredStatus);
            roomPrice.setStatus(actualStatus);
        } else if (compareDate > 0) {
            roomPrice.setStatus(awaitingStatus);
        }
        roomPriceService.saveRoomPrice(roomPrice);
        roomPriceService.saveRoomPrice(actualPrice);

        return "redirect:/price_manager";
    }
}
