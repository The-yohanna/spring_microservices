package com.johanna.employeeservice.service.impl;

import com.johanna.employeeservice.dto.EmployeeDto;
import com.johanna.employeeservice.exception.ResourceNotFoundException;
import com.johanna.employeeservice.mapper.EmployeeMapper;
import com.johanna.employeeservice.model.Employee;
import com.johanna.employeeservice.repository.EmployeeRepository;
import com.johanna.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.INSTANCE.mapToEmployee(employeeDto);
        return EmployeeMapper.INSTANCE.mapToEmployeeDto(
                employeeRepository.save(employee)
        );

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        return EmployeeMapper.INSTANCE.mapToEmployeeDto(employee);

    }

}
