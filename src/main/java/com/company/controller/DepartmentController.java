package com.company.controller;

import com.company.entity.Department;
import com.company.payload.DepartmentDto;
import com.company.repository.DepartmentRepository;
import com.company.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  16:05
 */

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam("companyId") Long companyId,
                                    @RequestBody DepartmentDto dto){
        return ResponseEntity.ok(departmentService.create(companyId,dto));
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(departmentService.getAll());
    }
}
