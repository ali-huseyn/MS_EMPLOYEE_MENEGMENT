package org.example.msemployeemanagment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.msemployeemanagment.enums.EmployeeStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String position;
    private Double salary;

}
