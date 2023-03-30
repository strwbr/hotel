package com.example.hotel.services;

import com.example.hotel.model.Street;

import java.util.List;

public interface StreetService {
    List<Street> getAllStreets();
    void saveStreet(Street street);
    Street getStreetById(long id);
    void deleteStreetById(long id);
}
