package com.example.employeeservice.employeedto;

import com.example.employeeservice.entity.Employee;

public class EmployeeDtoService {

    public static EmployeeDto convertToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );
        return employeeDto;
    }

    public static Employee convertToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode(),
                employeeDto.getOrganizationCode()
        );
        return employee;
    }
}
