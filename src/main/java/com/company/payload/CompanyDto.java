package com.company.payload;

import com.company.entity.Company;
import com.company.payload.AddressDto;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Company} entity
 */
@Data
public class CompanyDto implements Serializable {
    private Long id;
    private String corpName;
    private String directorName;
    private AddressDto address;
}