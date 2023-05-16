package com.example.hotel.services;

import com.example.hotel.model.Client;
import com.example.hotel.model.Employee;
import com.example.hotel.model.OccupiedRoom;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients(); // получение списка всех клиентов
    void saveClient(Client client); // сохранение клиента
    Client getClientById(long id); // получение клиента по ID
    void deleteClientById(long id); // удаление клиента по ID

    List<Client> getAllOrderedClients(); // получение списка всех клиентов, отсортированных по алфавиту
    boolean isVIPClient(Client client); // проверка, вляется ли клиент ВИП-клиентом
}
