package com.lombok.demo.mapper;

import com.lombok.demo.dto.EmployeeDto;
import com.lombok.demo.model.Employee;

public class EmployeeMapper {
    public static EmployeeDto toEmployeeDto(Employee employee) {
        return  EmployeeDto.builder()
            .id(employee.getId())
            .addresses(employee.getAddresses())
            .skills(employee.getSkills())
            .name(employee.getName())
            .build();
    }

    public static Employee toEmployee(EmployeeDto employeeDto) {
        return Employee.builder()
            .id(employeeDto.getId())
            .name(employeeDto.getName())
            .skills(employeeDto.getSkills())
            .addresses(employeeDto.getAddresses())
            .build();
    }
}
