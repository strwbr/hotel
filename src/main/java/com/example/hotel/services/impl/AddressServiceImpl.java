package com.example.hotel.services.impl;

import com.example.hotel.model.Address;
import com.example.hotel.repos.AddressRepository;
import com.example.hotel.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void saveAddress(Address address) {
        this.addressRepository.save(address);
    }

    @Override
    public Address getAddressById(long id) {
        Optional<Address> optionalAddress =
                addressRepository.findById(id);
        Address address = null;
        if (optionalAddress.isPresent()) {
            address = optionalAddress.get();
        } else {
            throw new RuntimeException("Address NOT found for id : " + id);
        }
        return address;
    }

    @Override
    public void deleteAddressById(long id) {
        this.addressRepository.deleteById(id);
    }
}
