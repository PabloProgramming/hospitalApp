package com.app.hospital.repository;

import com.app.hospital.model.Doctor;
import com.app.hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, String> {

    void delete(Hospital hospital);

    Hospital getHospitalByName(String hospitalId);
}

