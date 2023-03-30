package com.example.hotel.services.impl;

import com.example.hotel.model.StreetType;
import com.example.hotel.repos.StreetTypeRepository;
import com.example.hotel.services.StreetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteStreetTypeById(long id) {
        this.repository.deleteById(id);
    }
}
