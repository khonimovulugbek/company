package com.company.controller;

import com.company.entity.WorkerDto;
import com.company.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  16:05
 */

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/worker")
public class WorkerController {
    private final WorkerService workerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam("addressId") Long addressId,
                                    @RequestParam("departmentId") Long departmentId,
                                    @RequestBody WorkerDto dto) {
        return ResponseEntity.ok(workerService.create(addressId, departmentId, dto));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(workerService.getAll());
    }
}
