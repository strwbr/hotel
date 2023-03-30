package com.example.hotel.services.impl;

import com.example.hotel.model.PrepaymentStatus;
import com.example.hotel.repos.PrepaymentStatusRepository;
import com.example.hotel.services.PrepaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrepaymentStatusServiceImpl implements PrepaymentStatusService {

    @Autowired
    private PrepaymentStatusRepository repository;

    @Override
    public List<PrepaymentStatus> getAllPrepaymentStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void savePrepaymentStatus(PrepaymentStatus prepaymentStatus) {
        this.repository.save(prepaymentStatus);
    }

    @Override
    public PrepaymentStatus getPrepaymentStatusById(long id) {
        return null;
    }

    @Override
    public void deletePrepaymentStatusById(long id) {
        this.repository.deleteById(id);
    }
}
