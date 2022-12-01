package com.example.employeeservice.service;

import com.example.employeeservice.employeedto.EmployeeDto;
import com.example.employeeservice.entity.EmployeeWithDepartment;

public interface EmployeeService {

    public EmployeeDto saveEmployee(EmployeeDto employeeDto);
    public EmployeeWithDepartment getEmployee(Long id);
}
