package com.johanna.departmentservice.controller;

import com.johanna.departmentservice.dto.DepartmentDto;
import com.johanna.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "DepartmentController",
        description = "This controller exposes endpoints for interacting with departments"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @Operation(
            summary = "Save department endpoint",
            description = "Endpoint for creating and saving a new department in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Department successfully created"

    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get department endpoint",
            description = "Endpoint for retrieving department by department code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Department successfully retrieved"

    )
    @GetMapping("/{dept_code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("dept_code") String departmentCode) {
        DepartmentDto department = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

}
