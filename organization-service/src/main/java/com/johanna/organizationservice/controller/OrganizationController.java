package com.johanna.organizationservice.controller;

import com.johanna.organizationservice.dto.OrganizationDTO;
import com.johanna.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "OrganizationController",
        description = "This controller exposes endpoints for interacting with organizations"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @Operation(
            summary = "Save organization endpoint",
            description = "Endpoint for creating and saving a new organization in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Organization successfully created"

    )
    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO savedOrganization = organizationService.saveOrganization(organizationDTO);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get organization endpoint",
            description = "Endpoint for retrieving organization by organization code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Organization successfully retrieved"

    )
    @GetMapping("/{organization_code}")
    public ResponseEntity<OrganizationDTO> getOrganization(
            @PathVariable("organization_code") String organizationCode) {
        OrganizationDTO organization = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

}
