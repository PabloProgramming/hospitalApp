package com.app.hospital.repository;

import com.app.hospital.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> getAppointmentsByDoctorDoctorNumber(Long doctorNumber);

    Optional<Appointment> getAppointmentByPatientId(Long patientId);


}
