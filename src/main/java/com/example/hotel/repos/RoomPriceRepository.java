package com.example.hotel.repos;

import com.example.hotel.model.RoomPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomPriceRepository extends JpaRepository<RoomPrice, Long> {

    // Поиск цены типа номера по его id и id статуса цены
    @Query(value = "SELECT rp.*\n" +
            "FROM public.room_price rp\n" +
            "JOIN public.room_price_status rps ON rp.status_id = rps.id\n" +
            "JOIN public.room_type rt ON rp.room_type_id = rt.id\n" +
            "WHERE rt.id = :roomTypeId \n" +
            "AND rps.name = :priceStatusName", nativeQuery = true)
    Optional<RoomPrice> getRoomPriceByRoomTypeIdAndStatusName(@Param("roomTypeId") long roomTypeId,
                                                              @Param("priceStatusName") String priceStatusName);
}