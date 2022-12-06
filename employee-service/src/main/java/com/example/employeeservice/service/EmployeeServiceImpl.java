package com.example.employeeservice.service;

import com.example.employeeservice.employeedto.DepartmentDto;
import com.example.employeeservice.employeedto.EmployeeDto;
import com.example.employeeservice.employeedto.EmployeeDtoService;
import com.example.employeeservice.employeedto.OrganizationDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.entity.EmployeeWithDepartment;
import com.example.employeeservice.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;
    //   private RestTemplate restTemplate;
    //   private WebClient webClient;
    private APIClient apiClient;
    private APIClientOrganization apiClientOrganization;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeDtoService.convertToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeDtoService.convertToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name", fallbackMethod = "getDefaultDepartment")
    @Override
    public EmployeeWithDepartment getEmployee(Long id) {

        logger.info("Inside getEmployee()");
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = EmployeeDtoService.convertToEmployeeDto(employee);

//        Microservice call using RestTemplate
//        ResponseEntity<DepartmentDto>  responseEntity = restTemplate.getForEntity(
//                "http://localhost:8082/api/department/getDepartmentByCode?departmentCode="+employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

//        Microservice call using RWebClient
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8082/api/department/getDepartmentByCode?departmentCode="+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        OrganizationDto organizationDto = apiClientOrganization.getOrganizationByCode(employee.getOrganizationCode());

        EmployeeWithDepartment employeeWithDepartment = new EmployeeWithDepartment(
                employeeDto,
                departmentDto,
                organizationDto
        );
        return employeeWithDepartment;
    }

    public EmployeeWithDepartment getDefaultDepartment(Long id, Exception exception){
        logger.info("Inside getDefaultDepartment()");
        LocalDateTime now = LocalDateTime.now();
        Employee employee = employeeRepository.findById(id).get();

        EmployeeDto employeeDto = EmployeeDtoService.convertToEmployeeDto(employee);

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(12L);
        departmentDto.setDepartmentName("Demo department");
        departmentDto.setDepartmentDescription("Demo description");
        departmentDto.setDepartmentCode("Demo code");

        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setId(12L);
        organizationDto.setOrganizationName("Demo organization");
        organizationDto.setOrganizationDescription("Demo description");
        organizationDto.setOrganizationCode("Demo code");
        organizationDto.setCreatedDate(now);

        EmployeeWithDepartment employeeWithDepartment = new EmployeeWithDepartment(
                employeeDto,
                departmentDto,
                organizationDto
        );
        return employeeWithDepartment;
    }
}
