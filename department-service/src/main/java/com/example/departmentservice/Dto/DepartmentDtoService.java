package com.example.departmentservice.Dto;

import com.example.departmentservice.entity.Department;

public class DepartmentDtoService {

    public static Department convertToDepartment(DepartmentDto departmentDto){
            Department department = new Department(
                    departmentDto.getId(),
                    departmentDto.getDepartmentName(),
                    departmentDto.getDepartmentDescription(),
                    departmentDto.getDepartmentCode()
            );
            return department;
    }

    public static DepartmentDto convertToDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }

}
