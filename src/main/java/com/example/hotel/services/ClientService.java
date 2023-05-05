package com.example.hotel.services;

import com.example.hotel.model.Client;
import com.example.hotel.model.Employee;
import com.example.hotel.model.OccupiedRoom;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    void saveClient(Client client);
    Client getClientById(long id);
    void deleteClientById(long id);

    List<Client> getAllOrderedClients();
    boolean isVIPClient(Client client);
}
