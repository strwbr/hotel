package com.example.hotel.repos;

import com.example.hotel.model.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStatusRepository extends JpaRepository<ClientStatus, Long> {
}