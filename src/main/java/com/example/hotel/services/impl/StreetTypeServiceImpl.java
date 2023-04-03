package com.example.hotel.services.impl;

import com.example.hotel.model.RoomStatus;
import com.example.hotel.model.StreetType;
import com.example.hotel.repos.StreetTypeRepository;
import com.example.hotel.services.StreetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetTypeServiceImpl implements StreetTypeService {

    @Autowired
    private StreetTypeRepository repository;

    @Override
    public List<StreetType> getAllStreetTypes() {
        return this.repository.findAll();
    }

    @Override
    public void saveStreetType(StreetType streetType) {
        this.repository.save(streetType);
    }

    @Override
    public StreetType getStreetTypeById(long id) {
        Optional<StreetType> optional = repository.findById(id);
        StreetType streetType = null;
        if (optional.isPresent())
            streetType = optional.get();
        else throw new RuntimeException("StreetType NOT found for id : " + id);
        return streetType;
    }

    @Override
    public void deleteStreetTypeById(long id) {
        this.repository.deleteById(id);
    }
}
