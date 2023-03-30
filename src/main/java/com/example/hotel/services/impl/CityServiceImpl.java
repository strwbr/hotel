package com.example.hotel.services.impl;

import com.example.hotel.model.City;
import com.example.hotel.repos.CityRepository;
import com.example.hotel.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> getAllCities() {
        return this.repository.findAll();
    }

    @Override
    public void saveCity(City city) {
        this.repository.save(city);
    }

    @Override
    public City getCityById(long id) {
        return null;
    }

    @Override
    public void deleteCityById(long id) {
        this.repository.deleteById(id);
    }
}
