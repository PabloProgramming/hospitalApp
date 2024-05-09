package com.app.hospital.repository;

import com.app.hospital.model.Doctor;
import com.app.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findDoctorsByDepartmentId(Long departmentId);
}
