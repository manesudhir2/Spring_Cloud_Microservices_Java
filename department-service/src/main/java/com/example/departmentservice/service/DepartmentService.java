package com.example.departmentservice.service;

import com.example.departmentservice.Dto.DepartmentDto;
import com.example.departmentservice.entity.Department;

public interface DepartmentService {

    public DepartmentDto saveDepartment(DepartmentDto departmentDto);
    public DepartmentDto getDepartmentByCode(String departmentCode);
}
