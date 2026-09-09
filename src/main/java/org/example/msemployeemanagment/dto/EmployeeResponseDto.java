package org.example.msemployeemanagment.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.msemployeemanagment.enums.EmployeeStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String position;
    private Double salary;
    private LocalDateTime hireDate;
        private EmployeeStatus status;
}
