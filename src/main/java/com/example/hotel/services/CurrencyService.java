package com.example.hotel.services;

import com.example.hotel.model.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> getAllCurrencies();
    void saveCurrency(Currency currency);
    Currency getCurrencyById(long id);
    void deleteCurrencyById(long id);
}
