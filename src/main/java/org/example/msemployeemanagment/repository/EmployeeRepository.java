package org.example.msemployeemanagment.repository;


import org.example.msemployeemanagment.entity.EmployeeEntity;
import org.example.msemployeemanagment.enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
        Optional<EmployeeEntity>  findByIdAndStatus(Long id, EmployeeStatus status);
}
