package com.example.hotel.repos;

import com.example.hotel.model.RoomTypeAdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeAdditionalServiceRepository extends JpaRepository<RoomTypeAdditionalService, Long> {
}