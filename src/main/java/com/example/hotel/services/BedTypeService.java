package com.example.hotel.services;

import com.example.hotel.model.BedType;

import java.util.List;

public interface BedTypeService {
    List<BedType> getAllBedTypes();
    void saveBedType(BedType bedType);
    BedType getBedTypeById(long id);
    void deleteBedTypeById(long id);
}
