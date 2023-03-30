package com.example.hotel.services.impl;

import com.example.hotel.model.CleaningStatus;
import com.example.hotel.repos.CleaningStatusRepository;
import com.example.hotel.services.CleaningStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleaningStatusServiceImpl implements CleaningStatusService {

    @Autowired
    private CleaningStatusRepository repository;

    @Override
    public List<CleaningStatus> getAllCleaningStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void saveCleaningStatus(CleaningStatus cleaningStatus) {
        this.repository.save(cleaningStatus);
    }

    @Override
    public CleaningStatus getCleaningStatusById(long id) {
        return null;
    }

    @Override
    public void deleteCleaningStatusById(long id) {
        this.repository.deleteById(id);
    }
}
