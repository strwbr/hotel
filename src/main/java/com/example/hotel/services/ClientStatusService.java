package com.example.hotel.services;

import com.example.hotel.model.ClientStatus;

import java.util.List;

public interface ClientStatusService {
    List<ClientStatus> getAllClientStatuses();
    void saveClientStatus(ClientStatus clientStatus);
    ClientStatus getClientStatusById(long id);
    void deleteClientStatusById(long id);
}
