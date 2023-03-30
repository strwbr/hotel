package com.example.hotel.services.impl;

import com.example.hotel.model.Currency;
import com.example.hotel.repos.CurrencyRepository;
import com.example.hotel.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    @Override
    public List<Currency> getAllCurrencies() {
        return this.repository.findAll();
    }

    @Override
    public void saveCurrency(Currency currency) {
        this.repository.save(currency);
    }

    @Override
    public Currency getCurrencyById(long id) {
        return null;
    }

    @Override
    public void deleteCurrencyById(long id) {
        this.repository.deleteById(id);
    }
}
