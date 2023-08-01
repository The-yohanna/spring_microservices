package com.johanna.employeeservice.service;

import com.johanna.employeeservice.dto.APIResponseDto;
import com.johanna.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);

}
