package com.app.hospital.controller;

import com.app.hospital.model.Patient;
import com.app.hospital.model.dto.patient.PatientDto;
import com.app.hospital.model.dto.patient.PatientRandomResponseDto;
import com.app.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;


    @GetMapping
    private ResponseEntity<List<Patient>> findAllPatients() {
        return ResponseEntity.ok(patientService.findAllPatients());
    }

    @GetMapping("/{name}")
    private ResponseEntity<Optional<Patient>> findPatientName(@PathVariable String patientName){
        return ResponseEntity.ok(patientService.findPatientByName(patientName));
    }

    @GetMapping("/{patientId}")
    private ResponseEntity<Optional<Patient>> getPatientInfo(@PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.findPatient(patientId));
    }

    @PostMapping
    private ResponseEntity<Patient> registerPatient(@RequestBody PatientDto patientDto) {
        return ResponseEntity.ok(patientService.savePatient(patientDto));
    }

    @GetMapping("/name/{patientName}")
    private ResponseEntity<PatientRandomResponseDto> randomInfoResponse(@PathVariable String patientName) {
        return ResponseEntity.ok(patientService.findPatientInfo(patientName));
    }


}
