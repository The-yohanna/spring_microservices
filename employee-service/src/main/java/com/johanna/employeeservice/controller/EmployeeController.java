package com.johanna.employeeservice.controller;

import com.johanna.employeeservice.dto.APIResponseDto;
import com.johanna.employeeservice.dto.EmployeeDto;
import com.johanna.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "EmployeeController",
        description = "This controller exposes endpoints for interacting with employees"
)
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @Operation(
            summary = "Save employee endpoint",
            description = "Endpoint for creating and saving a new employee in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Employee successfully created"

    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get employee endpoint",
            description = "Endpoint for retrieving employee by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Employee successfully retrieved"

    )
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId) {
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

}
