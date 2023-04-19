package com.company.service;

import com.company.entity.Address;
import com.company.entity.Company;
import com.company.payload.ApiResponse;
import com.company.payload.CompanyDto;
import com.company.repository.AddressRepository;
import com.company.repository.CompanyRepository;
import com.company.repository.DepartmentRepository;
import com.company.repository.WorkerRepository;
import com.company.utils.MapperUtils;
import com.company.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.company.utils.MapperUtils.map;
import static com.company.utils.ResponseUtil.error;
import static com.company.utils.ResponseUtil.success;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  14:14
 */

@Service
@Slf4j
public record CompanyService(
        CompanyRepository companyRepository,
        DepartmentRepository departmentRepository,
        AddressRepository addressRepository,
        WorkerRepository workerRepository
) {


    public ApiResponse create(Long addressId, CompanyDto dto) {
        Address address = addressRepository.findById(addressId).orElse(null);
        if (address == null) {
            return error("Address not found", 400);
        }
        Company company = map(dto, Company.class);
        if (company == null) {
            return error("Bad request", 400);
        }
        company.setAddress(address);
        Company saved = companyRepository.save(company);
        CompanyDto mapped = map(saved, CompanyDto.class);
        return success(mapped);
    }

    public List<CompanyDto> getAll() {
        return companyRepository.findAll().stream().map(
                company -> map(company, CompanyDto.class)
        ).toList();
    }
}
