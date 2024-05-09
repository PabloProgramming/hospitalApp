package com.app.hospital.service;

import com.app.hospital.model.Doctor;
import com.app.hospital.model.Hospital;
import com.app.hospital.repository.HospitalRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    private DoctorService doctorService;

    public List<Hospital> findAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public String deleteHospital(String hospitalName) {
        hospitalRepository.deleteById(hospitalName);
        return hospitalName;
    }

    @SneakyThrows
    public Hospital findHospitalById(String hospitalName) {
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(hospitalName);
        if (hospitalOptional.isPresent()) {
            return hospitalOptional.get();
        }
        throw new Exception();
    }

}





