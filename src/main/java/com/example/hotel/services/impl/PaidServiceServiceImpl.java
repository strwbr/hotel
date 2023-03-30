package com.example.hotel.services.impl;

import com.example.hotel.model.PaidService;
import com.example.hotel.repos.PaidServiceRepository;
import com.example.hotel.services.PaidServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deletePaidServiceById(long id) {
        this.repository.deleteById(id);
    }
}
