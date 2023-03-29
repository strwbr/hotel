package com.example.hotel.services;

import com.example.hotel.model.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();
    void saveCity(City city);
    City getCityById(long id);
    void deleteCityById(long id);
}
