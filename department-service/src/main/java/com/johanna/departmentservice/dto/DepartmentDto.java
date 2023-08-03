package com.johanna.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Department model details"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    @Schema(description = "Department name")
    private String departmentName;
    @Schema(description = "Department description")
    private String departmentDescription;
    @Schema(description = "Department code")
    private String departmentCode;

}
