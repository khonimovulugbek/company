package com.company.controller;

import com.company.payload.ApiResponse;
import com.company.payload.CompanyDto;
import com.company.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  14:05
 */

@RestController
@RequestMapping("/api/v1/company")
@Slf4j
public record CompanyController(
        CompanyService companyService
) {

    @PostMapping
    public ApiResponse create(@RequestParam("addressId") Long addressId,
                              @RequestBody CompanyDto dto) {
        return companyService.create(addressId, dto);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(companyService.getAll());
    }


}
