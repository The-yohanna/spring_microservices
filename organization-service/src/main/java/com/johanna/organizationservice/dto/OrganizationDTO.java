package com.johanna.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "Organization model details"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
    private Long id;
    @Schema(description = "Organization name")
    private String organizationName;
    @Schema(description = "Organization description")
    private String organizationDescription;
    @Schema(description = "Organization code")
    private String organizationCode;
    private LocalDateTime createdDate;
}
