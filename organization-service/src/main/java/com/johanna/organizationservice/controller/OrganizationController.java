package com.johanna.organizationservice.controller;

import com.johanna.organizationservice.dto.OrganizationDTO;
import com.johanna.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO savedOrganization = organizationService.saveOrganization(organizationDTO);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @GetMapping("/{organization_code}")
    public ResponseEntity<OrganizationDTO> getOrganization(
            @PathVariable("organization_code") String organizationCode) {
        OrganizationDTO organization = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

}
