package com.johanna.departmentservice.service.impl;

import com.johanna.departmentservice.dto.DepartmentDto;
import com.johanna.departmentservice.exception.ResourceNotFoundException;
import com.johanna.departmentservice.mapper.DepartmentMapper;
import com.johanna.departmentservice.model.Department;
import com.johanna.departmentservice.repository.DepartmentRepository;
import com.johanna.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.INSTANCE.mapToDepartment(departmentDto);
        return DepartmentMapper.INSTANCE.mapToDepartmentDTO(
                departmentRepository.save(department)
        );

    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "code", departmentCode));
        return DepartmentMapper.INSTANCE.mapToDepartmentDTO(department);

    }

}
