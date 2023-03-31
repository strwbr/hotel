package com.example.hotel.services.impl;

import com.example.hotel.model.OccupiedRoom;
import com.example.hotel.model.PaidService;
import com.example.hotel.repos.PaidServiceRepository;
import com.example.hotel.services.PaidServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaidServiceServiceImpl implements PaidServiceService {

    @Autowired
    private PaidServiceRepository repository;

    @Override
    public List<PaidService> getAllPaidServices() {
        return this.repository.findAll();
    }

    @Override
    public void savePaidService(PaidService paidService) {
        this.repository.save(paidService);
    }

    @Override
    public PaidService getPaidServiceById(long id) {
        Optional<PaidService> optional = repository.findById(id);
        PaidService paidService = null;
        if (optional.isPresent())
            paidService = optional.get();
        else throw new RuntimeException("PaidService NOT found for id : \" + id");
        return paidService;
    }

    @Override
    public void deletePaidServiceById(long id) {
        this.repository.deleteById(id);
    }
}
