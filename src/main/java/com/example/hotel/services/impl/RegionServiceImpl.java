package com.example.hotel.services.impl;

import com.example.hotel.model.PrepaymentStatus;
import com.example.hotel.model.Region;
import com.example.hotel.repos.RegionRepository;
import com.example.hotel.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository repository;

    @Override
    public List<Region> getAllRegions() {
        return this.repository.findAll();
    }

    @Override
    public void saveRegion(Region region) {
        this.repository.save(region);
    }

    @Override
    public Region getRegionById(long id) {
        Optional<Region> optional = repository.findById(id);
        Region region = null;
        if (optional.isPresent())
            region = optional.get();
        else throw new RuntimeException("Region NOT found for id : \" + id");
        return region;
    }

    @Override
    public void deleteRegionById(long id) {
        this.repository.deleteById(id);
    }
}
