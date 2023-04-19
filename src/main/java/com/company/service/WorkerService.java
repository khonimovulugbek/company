package com.company.service;

import com.company.entity.Address;
import com.company.entity.Department;
import com.company.entity.Worker;
import com.company.entity.WorkerDto;
import com.company.payload.ApiResponse;
import com.company.repository.AddressRepository;
import com.company.repository.DepartmentRepository;
import com.company.repository.WorkerRepository;
import com.company.utils.MapperUtils;
import com.company.utils.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.company.utils.MapperUtils.map;
import static com.company.utils.ResponseUtil.success;

/**
 * Author: Khonimov Ulugbek
 * Date: 19.04.2023  16:19
 */

@Service
@AllArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final AddressRepository addressRepository;
    private final DepartmentRepository departmentRepository;

    public ApiResponse create(Long addressId, Long departmentId, WorkerDto dto) {
        Address address = addressRepository.findById(addressId).orElse(null);
        if (address == null) {
            return ResponseUtil.error("Address not found ", 409);
        }
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department == null) {
            return ResponseUtil.error("Department not found ", 409);
        }

        Worker worker = map(dto, Worker.class);
        if (worker == null) {
            return ResponseUtil.error("Bad request", 400);
        }
        worker.setAddress(address);
        worker.setDepartment(department);

        Worker save = workerRepository.save(worker);

        return success(map(save, WorkerDto.class));
    }

    public List<WorkerDto> getAll() {
        return workerRepository.findAll()
                .stream().map(
                        worker -> map(worker, WorkerDto.class)
                ).toList();
    }
}
