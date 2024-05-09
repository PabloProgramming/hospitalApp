package com.app.hospital.service;

import com.app.hospital.model.Department;
import com.app.hospital.model.Hospital;
import com.app.hospital.model.dto.department.AddDepartmentDto;
import com.app.hospital.repository.DepartmentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private HospitalService hospitalService;


    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public List<Department> findDepartmentByHospital(String hospitalName) {
        return departmentRepository.getDepartmentsByHospitalName(hospitalName);

    }


    public Department addDepartment(AddDepartmentDto departmentDto) {
        Hospital hospital = hospitalService.findHospitalById(departmentDto.getHospitalName());
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setHospital(hospital);
        return departmentRepository.save(department);
    }


    public String deleteDepartment(Long departmentId) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isPresent()) {
            departmentRepository.deleteById(departmentId);
            return departmentOptional.get().getName();
        }
        return null;
    }

    @SneakyThrows
    public Department findDepartmentById(Long departmentId) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isPresent()) {
            return departmentOptional.get();
        }
        throw new Exception();
    }

}

