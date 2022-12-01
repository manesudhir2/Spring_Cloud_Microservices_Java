package com.example.employeeservice.controller;

import com.example.employeeservice.employeedto.EmployeeDto;
import com.example.employeeservice.entity.EmployeeWithDepartment;
import com.example.employeeservice.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);

    }

    @GetMapping("/getEmployee")
    public ResponseEntity<EmployeeWithDepartment> getEmployee(@RequestParam Long id){
        EmployeeWithDepartment employeeWithDepartment = employeeService.getEmployee(id);
        return new ResponseEntity<>(employeeWithDepartment, HttpStatus.OK);
    }

}
