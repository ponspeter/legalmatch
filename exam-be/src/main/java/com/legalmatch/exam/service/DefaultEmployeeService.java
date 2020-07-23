package com.legalmatch.exam.service;

import com.legalmatch.exam.dto.EmployeeDto;

import java.util.List;

public interface DefaultEmployeeService {

    List<EmployeeDto> getEmployees();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto saveEmployee(EmployeeDto request);
    EmployeeDto updateEmployee(Long id, EmployeeDto request);
    Void removeEmployee(Long id);
}
