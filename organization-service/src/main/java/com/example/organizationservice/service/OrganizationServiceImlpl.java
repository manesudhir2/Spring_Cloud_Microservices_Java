package com.example.organizationservice.service;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.dto.OrganizationMapper;
import com.example.organizationservice.entity.Organization;
import com.example.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImlpl implements OrganizationService{

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.convertToOOrganization(organizationDto);
        Organization saved = organizationRepository.save(organization);
        return OrganizationMapper.convertToOrganizationDto(saved);
    }

    @Override
    public OrganizationDto getByOrganizationDto(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.convertToOrganizationDto(organization);
    }
}
