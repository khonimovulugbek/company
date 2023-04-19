package com.company.service;

import com.company.entity.Company;
import com.company.entity.Department;
import com.company.payload.ApiResponse;
import com.company.payload.DepartmentDto;
import com.company.repository.CompanyRepository;
import com.company.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.company.utils.MapperUtils.map;
import static com.company.utils.ResponseUtil.error;
import static com.company.utils.ResponseUtil.success;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  16:06
 */

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;

    public ApiResponse create(Long companyId, DepartmentDto dto) {
        Company company = companyRepository.findById(companyId).orElse(null);
        if (company == null) {
            return error("Error", 400);
        }
        Department department = map(dto, Department.class);
        if (department == null) {
            return error("Error", 400);
        }
        department.setCompany(company);
        Department saved = departmentRepository.save(department);
        return success(map(saved, DepartmentDto.class));
    }

    public List<DepartmentDto> getAll() {

        return departmentRepository.findAll()
                .stream().map(
                        department -> map(department, DepartmentDto.class)
                ).toList();
    }
}
