package com.example.hotel.repos;

import com.example.hotel.model.DepartmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentStatusRepository extends JpaRepository<DepartmentStatus, Long> {
}