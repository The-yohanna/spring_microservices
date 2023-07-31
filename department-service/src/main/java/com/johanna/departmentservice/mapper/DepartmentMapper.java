package com.johanna.departmentservice.mapper;

import com.johanna.departmentservice.dto.DepartmentDto;
import com.johanna.departmentservice.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDto mapToDepartmentDTO(Department department);
    Department mapToDepartment(DepartmentDto departmentDto);

}
