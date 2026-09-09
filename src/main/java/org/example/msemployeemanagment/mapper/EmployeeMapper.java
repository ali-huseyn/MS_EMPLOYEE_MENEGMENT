package org.example.msemployeemanagment.mapper;

import org.example.msemployeemanagment.dto.EmployeeRequestDto;
import org.example.msemployeemanagment.dto.EmployeeResponseDto;
import org.example.msemployeemanagment.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Mapper(componentModel = "spring")

public interface EmployeeMapper {

    EmployeeEntity toEmployeeEntity(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto toEmployeeResponseDto(EmployeeEntity employeeEntity);
    List<EmployeeResponseDto> toEmployeeResponseDto(List<EmployeeEntity> employeeEntityList);
    EmployeeEntity toEmployeeEntityFromRequestDto(@MappingTarget EmployeeEntity employeeEntity, EmployeeRequestDto employeeRequestDto);




}
