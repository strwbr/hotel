package com.example.hotel.services.impl;

import com.example.hotel.model.ExtraBed;
import com.example.hotel.repos.ExtraBedRepository;
import com.example.hotel.services.ExtraBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteExtraBedById(long id) {
        this.repository.deleteById(id);
    }
}
