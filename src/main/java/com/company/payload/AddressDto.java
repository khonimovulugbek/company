package com.company.payload;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.company.entity.Address} entity
 */
@Data
public class AddressDto implements Serializable {
    private Long id;
    private String street;
    private String homeNumber;
}