package com.example.hotel.services;

import com.example.hotel.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();
    void saveAddress(Address address);
    Address getAddressById(long id);
    void deleteAddressById(long id);
}
