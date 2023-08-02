package com.johanna.organizationservice.service.impl;

import com.johanna.organizationservice.dto.OrganizationDTO;
import com.johanna.organizationservice.exception.ResourceNotFoundException;
import com.johanna.organizationservice.mapper.OrganizationMapper;
import com.johanna.organizationservice.model.Organization;
import com.johanna.organizationservice.repository.OrganizationRepository;
import com.johanna.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {

        Organization organization = OrganizationMapper.INSTANCE.mapToOrganization(organizationDTO);
        return OrganizationMapper.INSTANCE.mapToOrganizationDTO(
                organizationRepository.save(organization)
        );

    }

    @Override
    public OrganizationDTO getOrganizationByCode(String organizationCode) {

        Organization organization = organizationRepository.findByOrganizationCode(organizationCode)
                .orElseThrow(() -> new ResourceNotFoundException("Organization", "code", organizationCode));
        return OrganizationMapper.INSTANCE.mapToOrganizationDTO(organization);

    }

}
