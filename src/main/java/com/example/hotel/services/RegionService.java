package com.example.hotel.services;

import com.example.hotel.model.Region;

import java.util.List;

public interface RegionService {
    List<Region> getAllRegions();
    void saveRegion(Region region);
    Region getRegionById(long id);
    void deleteRegionById(long id);
}
