package com.johanna.organizationservice.mapper;

import com.johanna.organizationservice.dto.OrganizationDTO;
import com.johanna.organizationservice.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {

    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);
    OrganizationDTO mapToOrganizationDTO(Organization organization);
    Organization mapToOrganization(OrganizationDTO organizationDTO);

}
