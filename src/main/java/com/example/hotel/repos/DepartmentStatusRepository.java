package com.example.hotel.repos;

import com.example.hotel.model.DepartmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentStatusRepository extends JpaRepository<DepartmentStatus, Long> {

    @Query(value = "SELECT * FROM department_status ds WHERE ds.name = :name", nativeQuery = true)
    Optional<DepartmentStatus> findByName(@Param("name") String name);
}