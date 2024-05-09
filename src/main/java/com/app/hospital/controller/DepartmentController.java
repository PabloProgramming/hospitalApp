package com.app.hospital.controller;

import com.app.hospital.model.Department;
import com.app.hospital.model.dto.department.AddDepartmentDto;
import com.app.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    @GetMapping
    private ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

    @GetMapping("/{hospitalName}")
    private ResponseEntity<List<Department>> getAllDepartmentsByHospital(@PathVariable String hospitalName) {
        return ResponseEntity.ok(departmentService.findDepartmentByHospital(hospitalName));
    }

    @PostMapping
    private ResponseEntity<Department> addDepartmentToHospital(@RequestBody AddDepartmentDto department) {
        return ResponseEntity.ok(departmentService.addDepartment(department));
    }

    @DeleteMapping("/{departmentId}")
    private ResponseEntity<String> deleteHospitalDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentService.deleteDepartment(departmentId));
    }


}





