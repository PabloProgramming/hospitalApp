package com.app.hospital.repository;

import com.app.hospital.model.favorites.DoctorFav;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorFavRepository extends JpaRepository<DoctorFav, Long> {

    List<DoctorFav> findDoctorFavsByPatientId(Long patientId);
}
