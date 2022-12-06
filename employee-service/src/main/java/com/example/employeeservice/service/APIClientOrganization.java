package com.example.employeeservice.service;

import com.example.employeeservice.employeedto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface APIClientOrganization {

    @GetMapping("api/organization/get")
    OrganizationDto getOrganizationByCode(@RequestParam String organizationCode);
}
