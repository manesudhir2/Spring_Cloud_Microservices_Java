package com.example.employeeservice.service;

import com.example.employeeservice.employeedto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/department/getDepartmentByCode")
    DepartmentDto getDepartmentByCode(@RequestParam String departmentCode);

}
