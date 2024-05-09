package com.app.hospital.service;

import com.app.hospital.model.Department;
import com.app.hospital.model.Hospital;
import com.app.hospital.model.Patient;
import com.app.hospital.model.dto.patient.PatientDto;
import com.app.hospital.model.dto.patient.PatientRandomResponseDto;
import com.app.hospital.repository.PatientRepository;
import com.app.hospital.service.mapper.PatientMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;


    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient savePatient(PatientDto patientDto) {
        Patient patient = patientMapper.dtoToEntity(patientDto);
        return patientRepository.save(patient);
    }

    public Optional<Patient> findPatientByName(String patientName){
        return patientRepository.findByName(patientName);
    }
    public Optional<Patient> findPatient(Long patientId) {
        return patientRepository.findById(patientId);
    }

    @SneakyThrows
    public Patient findPatientById(Long patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            return patientOptional.get();
        }
        throw new Exception();
    }

    public PatientRandomResponseDto findPatientInfo(String patientName) {
        Optional<Patient> patient = patientRepository.findByName(patientName);
        if (patient.isPresent()) {
            return patientMapper.patientToResponse(patient.get());
        }
        throw new RuntimeException("Patient not found");
    }


}

