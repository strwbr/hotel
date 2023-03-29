package com.example.hotel.repos;

import com.example.hotel.model.RoomTypeRoomEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRoomEquipmentRepository extends JpaRepository<RoomTypeRoomEquipment, Long> {
}