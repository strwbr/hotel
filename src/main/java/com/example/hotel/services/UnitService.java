package com.example.hotel.services;

import com.example.hotel.model.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();
    void saveUnit(Unit unit);
    Unit getUnitById(long id);
    void deleteUnitById(long id);
}
