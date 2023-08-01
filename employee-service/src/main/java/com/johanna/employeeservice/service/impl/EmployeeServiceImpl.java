package com.johanna.employeeservice.service.impl;

import com.johanna.employeeservice.dto.APIResponseDto;
import com.johanna.employeeservice.dto.DepartmentDto;
import com.johanna.employeeservice.dto.EmployeeDto;
import com.johanna.employeeservice.exception.ResourceNotFoundException;
import com.johanna.employeeservice.mapper.EmployeeMapper;
import com.johanna.employeeservice.model.Employee;
import com.johanna.employeeservice.repository.EmployeeRepository;
import com.johanna.employeeservice.service.APIClient;
import com.johanna.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.INSTANCE.mapToEmployee(employeeDto);
        return EmployeeMapper.INSTANCE.mapToEmployeeDto(
                employeeRepository.save(employee)
        );

    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(employee);

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        /*DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode() )
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

        return new APIResponseDto(employeeDto, departmentDto);

    }

}
