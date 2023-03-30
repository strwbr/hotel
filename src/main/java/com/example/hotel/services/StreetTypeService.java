package com.example.hotel.services;

import com.example.hotel.model.StreetType;

import java.util.List;

public interface StreetTypeService {
    List<StreetType> getAllStreetTypes();
    void saveStreetType(StreetType streetType);
    StreetType getStreetTypeById(long id);
    void deleteStreetTypeById(long id);
}
