package com.example.hotel.services.impl;

import com.example.hotel.model.Street;
import com.example.hotel.repos.StreetRepository;
import com.example.hotel.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetRepository repository;

    @Override
    public List<Street> getAllStreets() {
        return this.repository.findAll();
    }

    @Override
    public void saveStreet(Street street) {
        this.repository.save(street);
    }

    @Override
    public Street getStreetById(long id) {
        return null;
    }

    @Override
    public void deleteStreetById(long id) {
        this.repository.deleteById(id);
    }
}
