package com.example.hotel.repos;

import com.example.hotel.model.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientStatusRepository extends JpaRepository<ClientStatus, Long> {

    @Query(value = "", nativeQuery = true)
    Optional<ClientStatus> findByName(@Param("name") String name);
}