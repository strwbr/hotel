package com.example.hotel.services.impl;

import com.example.hotel.model.AdditionalService;
import com.example.hotel.repos.AdditionalServiceRepository;
import com.example.hotel.services.AdditionalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AdditionalServiceServiceImpl implements AdditionalServiceService {

    @Autowired
    private AdditionalServiceRepository repository;

    @Override
    public List<AdditionalService> getAllAdditionalServices() {
        return repository.findAll();
    }

    @Override
    public void saveAdditionalService(AdditionalService additionalService) {
        this.repository.save(additionalService);
    }

    @Override
    public AdditionalService getAdditionalServiceById(long id) {
        Optional<AdditionalService> optionalAdditionalService
                = repository.findById(id);
        AdditionalService additionalService = null;
        if(optionalAdditionalService.isPresent()) {
            additionalService = optionalAdditionalService.get();
        } else {
            throw new RuntimeException("AdditionalService NOT found for id : " + id);
        }
        return additionalService;
    }

    @Override
    public void deleteAdditionalServiceById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Collection<String> getAllAdditionalServiceNames() {
        return this.repository.findAllNames();
    }

    @Override
    public List<AdditionalService> getAllAvailableAdditionalServices() {
        return this.repository.findAllByAvailabilityStatusName("Доступно");
    }
}
