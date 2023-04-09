package com.example.hotel.repos;

import com.example.hotel.model.OccupiedRoomClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupiedRoomClientRepository extends JpaRepository<OccupiedRoomClient, Long> {
}