package com.company.entity;

import com.company.payload.AddressDto;
import com.company.payload.DepartmentDto;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Worker} entity
 */
@Data
public class WorkerDto implements Serializable {
    private Long id;
    private String name;
    private String phoneNumber;
    private AddressDto address;
    private DepartmentDto department;
}