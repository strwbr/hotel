package com.example.hotel.repos;

import com.example.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT r.* FROM room r\n" +
            "WHERE r.room_type_id = :roomTypeId\n" +
            "AND r.id NOT IN (\n" +
            "SELECT br.room_id\n" +
            "FROM occupied_room br\n" +
            "JOIN booking b\n" +
            "ON b.id = br.booking_id\n" +
            "WHERE (\n" +
            ":checkInDate >= b.check_in_date\n" +
            "AND :checkInDate < b.check_out_date\n" +
            ") OR (\n" +
            ":checkOutDate > b.check_in_date\n" +
            "AND :checkOutDate <= b.check_out_date\n" +
            ") OR (\n" +
            ":checkInDate <= b.check_in_date\n" +
            "AND :checkOutDate >= b.check_out_date\n" +
            ") AND b.booking_status_id IN (:bookingStatusesId)" +
            ")", nativeQuery = true)
    List<Room> findAvailableRoomsByRoomTypeId(@Param("roomTypeId") Long roomTypeId,
                                              @Param("checkInDate") Date checkIndate,
                                              @Param("checkOutDate") Date checkOutDate,
                                              @Param("bookingStatusesId") List<Long> bookingStatusesId);

    @Query(value = "SELECT r.* FROM room r WHERE r.room_type_id = :roomTypeId", nativeQuery = true)
    List<Room> findAllByRoomTypeId(@Param("roomTypeId") Long roomTypeId);
}