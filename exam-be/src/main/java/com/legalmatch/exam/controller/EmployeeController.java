package com.legalmatch.exam.controller;

import com.legalmatch.exam.dto.BaseReponse;
import com.legalmatch.exam.dto.EmployeeDto;
import com.legalmatch.exam.enums.ResponseCode;
import com.legalmatch.exam.service.DefaultEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController implements DefaultEmployeeController {

    private final DefaultEmployeeService employeeService;

    @Override
    @GetMapping()
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    @Override
    @GetMapping("/{id}")
    public BaseReponse<EmployeeDto> getEmployeeById(@Min(1) @PathVariable("id") Long id) {
        return BaseReponse.<EmployeeDto>builder()
                .code(ResponseCode.SUCCESS)
                .data(employeeService.getEmployeeById(id))
                .build();
    }

    @Override
    @PostMapping()
    public BaseReponse<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto request) {
        return BaseReponse.<EmployeeDto>builder()
                .code(ResponseCode.SUCCESS)
                .data(employeeService.saveEmployee(request))
                .build();
    }

    @Override
    @PatchMapping("/{id}")
    public BaseReponse<EmployeeDto> updateEmployee(@Min(1) @PathVariable("id") Long id, @Valid @RequestBody EmployeeDto request) {
        return BaseReponse.<EmployeeDto>builder()
                .code(ResponseCode.SUCCESS)
                .data(employeeService.updateEmployee(id, request))
                .build();
    }

    @Override
    @DeleteMapping("/{id}")
    public BaseReponse<Void> removeEmployee(@Min(1) @PathVariable("id") Long id) {
        return BaseReponse.<Void>builder()
                .code(ResponseCode.SUCCESS_DELETE)
                .data(employeeService.removeEmployee(id))
                .build();
    }

    @Override
    @GetMapping("/search")
    public List<EmployeeDto> searchEmployee(@RequestParam(value = "param") String param) {
        List<EmployeeDto> list = employeeService.getEmployees(param);
        System.out.println("SIZE IS ::: " + list.size());
        return list;
    }
}
