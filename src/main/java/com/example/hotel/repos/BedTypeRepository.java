package com.example.hotel.repos;

import com.example.hotel.model.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BedTypeRepository extends JpaRepository<BedType, Long> {
    @Query(value = "SELECT name FROM bed_type", nativeQuery = true)
    Collection<String> findAllNames();

    @Query(value = "SELECT * FROM bed_type b WHERE b.name= : name;", nativeQuery = true)
    BedType findByName(@Param("name") String name);

    @Query(value = "SELECT bt.* FROM public.bed_type bt\n" +
            "JOIN public.room_type_bed_type rb\n" +
            "ON bt.id = rb.bed_type_id\n" +
            "JOIN public.room_type rt\n" +
            "ON rb.room_type_id = rt.id\n" +
            "WHERE rt.id = :roomTypeId", nativeQuery = true)
    List<BedType> findAllByRoomTypeId(@Param("roomTypeId") long id);
}