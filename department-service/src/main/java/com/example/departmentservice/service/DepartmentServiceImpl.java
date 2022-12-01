package com.example.departmentservice.service;

import com.example.departmentservice.Dto.DepartmentDto;
import com.example.departmentservice.Dto.DepartmentDtoService;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentDtoService.convertToDepartment(departmentDto);
        Department department1 = departmentRepository.save(department);
        DepartmentDto departmentDto1 = DepartmentDtoService.convertToDepartmentDto(department1);
        return departmentDto1;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentDtoService.convertToDepartmentDto(department);
        return departmentDto;
    }


}
