package org.example.msemployeemanagment.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.msemployeemanagment.enums.EmployeeStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String firstName;
     private String lastName;
     @Column(unique = true)
     private String email;
     @Column(unique = true)
     private String phoneNumber;
     private String position;
     private Double salary;
     private LocalDateTime hireDate= LocalDateTime.now();
     @Enumerated(EnumType.STRING)
     private EmployeeStatus status =EmployeeStatus.ACTIVE;



}
