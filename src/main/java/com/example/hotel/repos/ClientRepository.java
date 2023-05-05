package com.example.hotel.repos;

import com.example.hotel.model.Client;
import com.example.hotel.model.Employee;
import com.example.hotel.model.OccupiedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM client ORDER BY surname, name, patronymic", nativeQuery = true)
    List<Client> findAllOrderBySurnameNamePatronymic();
}