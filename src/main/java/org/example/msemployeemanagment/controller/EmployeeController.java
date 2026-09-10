package org.example.msemployeemanagment.controller;

import lombok.RequiredArgsConstructor;
import org.example.msemployeemanagment.dto.EmployeeRequestDto;
import org.example.msemployeemanagment.dto.EmployeeResponseDto;
import org.example.msemployeemanagment.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public void createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.createEmployee(employeeRequestDto);
    }
    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable Long id) {

        return employeeService.getEmployeeById(id);

    }
    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.updateEmployeeById(id,employeeRequestDto);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }
    //GET /api/employees?firstName=John
    @GetMapping("/filtir")
    public List<EmployeeResponseDto> filterEmployees(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String position
    ) {
        return employeeService.filterEmployees(firstName, lastName, position);
    }
    @GetMapping("/beatweansalary")
    public List<EmployeeResponseDto> getBeatweansalary(@RequestParam double salary, @RequestParam double salary2) {
        return employeeService.findEmployeesGreaterThanAndLessThan(salary, salary2);
    }


}
