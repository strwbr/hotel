package com.example.hotel.services.impl;

import com.example.hotel.model.Country;
import com.example.hotel.model.ExtraBed;
import com.example.hotel.repos.ExtraBedRepository;
import com.example.hotel.services.ExtraBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraBedServiceImpl implements ExtraBedService {

    @Autowired
    private ExtraBedRepository repository;

    @Override
    public List<ExtraBed> getAllExtraBeds() {
        return this.repository.findAll();
    }

    @Override
    public void saveExtraBed(ExtraBed extraBed) {
        this.repository.save(extraBed);
    }

    @Override
    public ExtraBed getExtraBedById(long id) {
        Optional<ExtraBed> optional = repository.findById(id);
        ExtraBed extraBed = null;
        if (optional.isPresent())
            extraBed = optional.get();
        else throw new RuntimeException("ExtraBed NOT found for id : \" + id");
        return extraBed;
    }

    @Override
    public void deleteExtraBedById(long id) {
        this.repository.deleteById(id);
    }
}
