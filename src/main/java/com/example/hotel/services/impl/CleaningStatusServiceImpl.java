package com.example.hotel.services.impl;

import com.example.hotel.model.CleaningStatus;
import com.example.hotel.repos.CleaningStatusRepository;
import com.example.hotel.services.CleaningStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<CleaningStatus> optional = repository.findById(id);
        CleaningStatus cleaningStatus = null;
        if (optional.isPresent())
            cleaningStatus = optional.get();
        else throw new RuntimeException("CleaningStatus NOT found for id : \" + id");
        return cleaningStatus;
    }

    @Override
    public void deleteCleaningStatusById(long id) {
        this.repository.deleteById(id);
    }
}
