package com.example.employeeservice.entity;

import com.example.employeeservice.employeedto.DepartmentDto;
import com.example.employeeservice.employeedto.EmployeeDto;
import com.example.employeeservice.employeedto.OrganizationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class EmployeeWithDepartment {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
    private OrganizationDto organizationDto;
}
