package com.app.hospital.repository;

import com.app.hospital.model.Department;
import com.app.hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> getDepartmentsByHospitalName(String hospitalName);

    Department getDepartmentByName(String departmentName);

}
