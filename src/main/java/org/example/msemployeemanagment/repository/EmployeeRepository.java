package org.example.msemployeemanagment.repository;


import org.example.msemployeemanagment.entity.EmployeeEntity;
import org.example.msemployeemanagment.enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByIdAndStatus(Long id, EmployeeStatus status);

    List<EmployeeEntity> findByFirstNameIs(String firstName);

    List<EmployeeEntity> findByLastNameIs(String lastName);

    List<EmployeeEntity> findByPositionIs(String position);
    List<EmployeeEntity>findBySalaryGreaterThanAndSalaryLessThan(Double salary1, Double salary2);


}
