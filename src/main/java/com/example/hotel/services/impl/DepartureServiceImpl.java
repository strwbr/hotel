package com.example.hotel.services.impl;

import com.example.hotel.model.Departure;
import com.example.hotel.repos.DepartureRepository;
import com.example.hotel.services.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartureServiceImpl implements DepartureService {

    @Autowired
    private DepartureRepository repository;

    @Override
    public List<Departure> getAllDepartures() {
        return this.repository.findAll();
    }

    @Override
    public void saveDeparture(Departure departure) {
        this.repository.save(departure);
    }

    @Override
    public Departure getDepartureById(long id) {
        Optional<Departure> optional = repository.findById(id);
        Departure departure = null;
        if (optional.isPresent())
            departure = optional.get();
        else throw new RuntimeException("Departure NOT found for id : \" + id");
        return departure;
    }

    @Override
    public void deleteDepartureById(long id) {
        this.repository.deleteById(id);
    }
}
