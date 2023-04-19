package com.company.service;

import com.company.entity.Address;
import com.company.payload.AddressDto;
import com.company.payload.ApiResponse;
import com.company.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.company.utils.MapperUtils.map;
import static com.company.utils.ResponseUtil.error;
import static com.company.utils.ResponseUtil.success;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  15:06
 */
@Service
public record AddressService(
        AddressRepository addressRepository
) {


    public ApiResponse create(AddressDto dto) {
        Address address = map(dto, Address.class);
        if (address == null) {
            return error("Bad request", 400);
        }
        Address save = addressRepository.save(address);
        AddressDto map = map(save, AddressDto.class);
        return success(map);
    }

    public ApiResponse getAll() {
        List<AddressDto> list = addressRepository.findAll()
                .stream().map(
                        address -> map(address, AddressDto.class)
                ).toList();
        return success(list);
    }
}
