package com.example.hotel.services.impl;

import com.example.hotel.model.RoomStatus;
import com.example.hotel.model.Street;
import com.example.hotel.repos.StreetRepository;
import com.example.hotel.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Street> optional = repository.findById(id);
        Street street = null;
        if (optional.isPresent())
            street = optional.get();
        else throw new RuntimeException("Street NOT found for id : \" + id");
        return street;
    }

    @Override
    public void deleteStreetById(long id) {
        this.repository.deleteById(id);
    }
}
