package com.example.hotel.repos;

import com.example.hotel.model.OccupiedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupiedRoomRepository extends JpaRepository<OccupiedRoom, Long> {
}