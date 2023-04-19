package com.company.payload;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.company.entity.Department} entity
 */
@Data
public class DepartmentDto implements Serializable {
    private Long id;
    private String name;
    private CompanyDto company;
}