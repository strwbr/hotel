package com.example.hotel.services.impl;

import com.example.hotel.model.AvailabilityStatus;
import com.example.hotel.repos.AvailabilityStatusRepository;
import com.example.hotel.services.AvailabilityStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityStatusServiceImpl implements AvailabilityStatusService {

    @Autowired
    private AvailabilityStatusRepository repository;

    @Override
    public List<AvailabilityStatus> getAllAvailabilityStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void saveAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        repository.save(availabilityStatus);
    }

    @Override
    public AvailabilityStatus getAvailabilityStatusById(long id) {
        Optional<AvailabilityStatus> optional =
                this.repository.findById(id);
        AvailabilityStatus availabilityStatus = null;
        if(optional.isPresent()) {
            availabilityStatus = optional.get();
        } else
            throw new RuntimeException("AvailabilityStatus NOT found for id : " + id);
        return availabilityStatus;
    }

    @Override
    public void deleteAvailabilityStatusById(long id) {
        this.repository.deleteById(id);
    }
}
