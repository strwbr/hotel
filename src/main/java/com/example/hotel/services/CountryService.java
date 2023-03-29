package com.example.hotel.services;

import com.example.hotel.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    void saveCountry(Country country);
    Country getCountryById(long id);
    void deleteCountryById(long id);
}
