package com.example.hotel.services.impl;

import com.example.hotel.model.RoomStatus;
import com.example.hotel.model.Unit;
import com.example.hotel.repos.UnitRepository;
import com.example.hotel.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository repository;

    @Override
    public List<Unit> getAllUnits() {
        return this.repository.findAll();
    }

    @Override
    public void saveUnit(Unit unit) {
        this.repository.save(unit);
    }

    @Override
    public Unit getUnitById(long id) {
        Optional<Unit> optional = repository.findById(id);
        Unit unit = null;
        if (optional.isPresent())
            unit = optional.get();
        else throw new RuntimeException("Unit NOT found for id : \" + id");
        return unit;
    }

    @Override
    public void deleteUnitById(long id) {
        this.repository.deleteById(id);
    }
}
