package com.legalmatch.exam.controller;

import com.legalmatch.exam.dto.BaseReponse;
import com.legalmatch.exam.dto.EmployeeDto;
import com.legalmatch.exam.enums.ResponseCode;
import com.legalmatch.exam.service.DefaultEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController implements DefaultEmployeeController {

    private final DefaultEmployeeService employeeService;

    @Override
    @GetMapping()
    public BaseReponse<List<EmployeeDto>> getEmployees() {
        return BaseReponse.<List<EmployeeDto>>builder()
                .code(ResponseCode.SUCCESS)
                .data(employeeService.getEmployees())
                .build();
    }

    @Override
    @GetMapping("/{id}")
    public BaseReponse<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        return BaseReponse.<EmployeeDto>builder()
                .code(ResponseCode.SUCCESS)
                .data(employeeService.getEmployeeById(id))
                .build();
    }

    @Override
    @PostMapping()
    public BaseReponse<EmployeeDto> saveEmployee(@RequestBody EmployeeDto request) {
        return BaseReponse.<EmployeeDto>builder()
                .code(ResponseCode.SUCCESS)
                .data(employeeService.saveEmployee(request))
                .build();
    }

    @Override
    @PatchMapping("/{id}")
    public BaseReponse<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto request) {
        return BaseReponse.<EmployeeDto>builder()
                .code(ResponseCode.SUCCESS)
                .data(employeeService.updateEmployee(id, request))
                .build();
    }

    @Override
    @DeleteMapping("/{id}")
    public BaseReponse<Void> removeEmployee(@PathVariable("id") Long id) {
        return BaseReponse.<Void>builder()
                .code(ResponseCode.SUCCESS_DELETE)
                .data(employeeService.removeEmployee(id))
                .build();
    }
}
