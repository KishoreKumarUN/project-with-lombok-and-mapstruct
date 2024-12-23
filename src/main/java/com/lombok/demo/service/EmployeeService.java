package com.lombok.demo.service;

import com.lombok.demo.dao.EmployeeDao;
import com.lombok.demo.dto.EmployeeDto;
import com.lombok.demo.mapper.EmployeeMapper;
import com.lombok.demo.model.Employee;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.lombok.demo.mapper.EmployeeMapper.toEmployee;
import static com.lombok.demo.mapper.EmployeeMapper.toEmployeeDto;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = toEmployee(employeeDto);
        return toEmployeeDto(employeeDao.save(employee));
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeDao.findAll().stream().map(EmployeeMapper::toEmployeeDto).collect(Collectors.toList());
    }
}
