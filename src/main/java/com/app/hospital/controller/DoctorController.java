package com.app.hospital.controller;

import com.app.hospital.model.Doctor;
import com.app.hospital.model.dto.doctor.DoctorDto;
import com.app.hospital.model.favorites.DoctorFav;
import com.app.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;


    @PostMapping
    private ResponseEntity<Doctor> saveDoctor(@RequestBody DoctorDto doctor) {
        return ResponseEntity.ok(doctorService.saveDoctor(doctor));
    }

    @GetMapping("/{departmentId}")
    private ResponseEntity<List<Doctor>> getDoctorsByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(doctorService.findDoctorByDepartment(departmentId));
    }

}
