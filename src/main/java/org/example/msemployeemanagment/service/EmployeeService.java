package org.example.msemployeemanagment.service;


import lombok.RequiredArgsConstructor;
import org.example.msemployeemanagment.constant.ErrorMessage;
import org.example.msemployeemanagment.dto.EmployeeRequestDto;
import org.example.msemployeemanagment.dto.EmployeeResponseDto;
import org.example.msemployeemanagment.entity.EmployeeEntity;
import org.example.msemployeemanagment.exception.EmployeeNotFoundException;
import org.example.msemployeemanagment.mapper.EmployeeMapper;
import org.example.msemployeemanagment.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.msemployeemanagment.constant.ErrorMessage.EMPLOYEE_NOT_FOUND;
import static org.example.msemployeemanagment.enums.EmployeeStatus.ACTIVE;
import static org.example.msemployeemanagment.enums.EmployeeStatus.INACTIVE;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public void createEmployee(EmployeeRequestDto employeeRequestDto) {

        var entity = employeeMapper.toEmployeeEntity(employeeRequestDto);
        employeeRepository.save(entity);

    }

    public EmployeeResponseDto getEmployeeById(Long id) {
        var entity = fetchEmployeeById(id);

        return employeeMapper.toEmployeeResponseDto(entity);

    }


    public List<EmployeeResponseDto> getAllEmployees() {
        List<EmployeeEntity> list = employeeRepository.findAll();

        return employeeMapper.toEmployeeResponseDto(list);
    }

    public void updateEmployeeById(Long id, EmployeeRequestDto employeeResuestDto) {
        var entity = fetchEmployeeById(id);
        var entityMap = employeeMapper.toEmployeeEntityFromRequestDto(entity, employeeResuestDto);
        employeeRepository.save(entityMap);

    }

    public void deleteEmployeeById(Long id) {
        var employeeEntity = fetchEmployeeById(id);
        employeeEntity.setStatus(INACTIVE);
        employeeRepository.save(employeeEntity);


    }

    public EmployeeEntity fetchEmployeeById(Long id) {
        var entity = employeeRepository.findByIdAndStatus(id, ACTIVE);
        if (entity.isEmpty()) {
            throw new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND);
        }
        return entity.get();
    }

    public List<EmployeeResponseDto>filterEmployees(String firstName,String lastName,String position){
        List<EmployeeEntity> employees;
        if (firstName != null) {
            employees = employeeRepository.findByFirstNameIs(firstName);
        } else if (lastName != null) {
            employees = employeeRepository.findByLastNameIs(lastName);
        } else if (position != null) {
            employees = employeeRepository.findByPositionIs(position);
        } else {
            employees = employeeRepository.findAll();
        }

        return employeeMapper.toEmployeeResponseDto(employees);
    }
    public List<EmployeeResponseDto>findEmployeesGreaterThanAndLessThan(Double salary1, Double salary2) {

                var employees=employeeRepository.findBySalaryGreaterThanAndSalaryLessThan(salary1, salary2);
                return employeeMapper.toEmployeeResponseDto(employees);
    }


}
