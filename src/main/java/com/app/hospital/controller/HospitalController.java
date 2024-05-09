package com.app.hospital.controller;

import com.app.hospital.model.Department;
import com.app.hospital.model.Doctor;
import com.app.hospital.model.Hospital;
import com.app.hospital.repository.HospitalRepository;
import com.app.hospital.service.HospitalService;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @PostMapping
    private ResponseEntity<Hospital> registerHospital(@RequestBody Hospital hospital) {
        return ResponseEntity.ok(hospitalService.saveHospital(hospital));
    }


    @DeleteMapping("/{hospitalName}")
    private ResponseEntity<String> deleteHospital(@PathVariable String hospitalName) {
        return ResponseEntity.ok(hospitalService.deleteHospital(hospitalName));
    }

    @GetMapping
    private ResponseEntity<List<Hospital>> findAllHospitals() {
        return ResponseEntity.ok(hospitalService.findAllHospitals());
    }


}
