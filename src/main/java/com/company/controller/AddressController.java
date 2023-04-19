package com.company.controller;

import com.company.payload.AddressDto;
import com.company.payload.ApiResponse;
import com.company.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
Author: Khonimov Ulugbek
Date: 19.04.2023  14:05
*/

@RestController
@RequestMapping("/api/v1/address")
@Slf4j
public record AddressController(
AddressService addressService
        ) {

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody AddressDto dto){
        return ResponseEntity.ok(addressService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll(){
        return ResponseEntity.ok(addressService.getAll());
    }

}
