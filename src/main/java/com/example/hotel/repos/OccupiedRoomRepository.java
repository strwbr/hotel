package com.example.hotel.repos;

import com.example.hotel.model.OccupiedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccupiedRoomRepository extends JpaRepository<OccupiedRoom, Long> {

    @Query(value = "SELECT r.* FROM public.occupied_room r JOIN public.occupied_room_client clr ON r.id = clr.occupied_room_id JOIN public.client cl ON clr.client_id = cl.id WHERE cl.id = :clientID", nativeQuery = true)
    List<OccupiedRoom> findAllOccupiedRoomsByClientId(@Param("clientID") long id);

}