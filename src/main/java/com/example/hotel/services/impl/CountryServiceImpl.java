package com.example.hotel.services.impl;

import com.example.hotel.model.Country;
import com.example.hotel.repos.CountryRepository;
import com.example.hotel.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> getAllCountries() {
        return this.repository.findAll();
    }

    @Override
    public void saveCountry(Country country) {
        this.repository.save(country);
    }

    @Override
    public Country getCountryById(long id) {
        return null;
    }

    @Override
    public void deleteCountryById(long id) {
        this.repository.deleteById(id);
    }
}
