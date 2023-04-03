package com.example.hotel.repos;

import com.example.hotel.model.RoomEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoomEquipmentRepository extends JpaRepository<RoomEquipment, Long> {
    @Query(value = "SELECT name FROM room_equipment", nativeQuery = true)
    Collection<String> findAllNames();
}