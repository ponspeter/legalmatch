package com.legalmatch.exam.controller;

import com.legalmatch.exam.dto.BaseReponse;
import com.legalmatch.exam.dto.EmployeeDto;

import java.util.List;

public interface DefaultEmployeeController {

    BaseReponse<List<EmployeeDto>> getEmployees();
    BaseReponse<EmployeeDto> getEmployeeById(Long id);
    BaseReponse<EmployeeDto> saveEmployee(EmployeeDto request);
    BaseReponse<EmployeeDto> updateEmployee(Long id, EmployeeDto request);
    BaseReponse<Void> removeEmployee(Long id);
}
