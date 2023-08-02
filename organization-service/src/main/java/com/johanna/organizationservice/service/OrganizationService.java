package com.johanna.organizationservice.service;

import com.johanna.organizationservice.dto.OrganizationDTO;

public interface OrganizationService {

    OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);
    OrganizationDTO getOrganizationByCode(String organizationCode);

}
