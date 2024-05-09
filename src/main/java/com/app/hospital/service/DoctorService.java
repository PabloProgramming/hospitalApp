package com.app.hospital.service;

import com.app.hospital.model.Department;
import com.app.hospital.model.Doctor;
import com.app.hospital.model.dto.doctor.DoctorDto;
import com.app.hospital.model.favorites.DoctorFav;
import com.app.hospital.repository.DoctorRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DepartmentService departmentService;


    public List<Doctor> findDoctorByDepartment(Long departmentId) {
        return doctorRepository.findDoctorsByDepartmentId(departmentId);
    }

    public Doctor saveDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setDoctorNumber(doctorDto.getDoctorNumber());
        doctor.setName(doctorDto.getName());
        doctor.setSurname(doctorDto.getSurname());
        Department departmentOptional = departmentService.findDepartmentById(doctorDto.getDepartmentId());
        doctor.setDepartment(departmentOptional);
        doctorRepository.save(doctor);
        return doctor;
    }


    @SneakyThrows
    public Doctor findDoctorById(Long doctorNumber) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorNumber);
        if (doctorOptional.isPresent()) {
            return doctorOptional.get();
        }
        throw new Exception();
    }
}
