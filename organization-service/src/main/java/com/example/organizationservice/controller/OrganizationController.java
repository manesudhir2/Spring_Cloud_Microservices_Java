package com.example.organizationservice.controller;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.service.OrganizationServiceImlpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organization")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationServiceImlpl organizationServiceImlpl;

    @PostMapping("/save")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto saved = organizationServiceImlpl.saveOrganization(organizationDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<OrganizationDto> getByOrganizationCode(@RequestParam String organizationCode){
        OrganizationDto organizationDto = organizationServiceImlpl.getByOrganizationDto(organizationCode);
        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
}
