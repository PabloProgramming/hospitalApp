package com.app.hospital.service.mapper;

import com.app.hospital.model.Department;
import com.app.hospital.model.Hospital;
import com.app.hospital.model.Patient;
import com.app.hospital.model.dto.appointment.AppointmentForPatientRandomResponseDto;
import com.app.hospital.model.dto.patient.PatientDto;
import com.app.hospital.model.dto.patient.PatientRandomResponseDto;
import com.app.hospital.service.AppointmentService;
import com.app.hospital.service.DepartmentService;
import com.app.hospital.service.DoctorService;
import com.app.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    @Autowired
    private HospitalService hospitalService;

    public Patient dtoToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setAge(patientDto.getAge());
        patient.setGender(patientDto.getGender());
        Hospital hospital = hospitalService.findHospitalById(patientDto.getHospitalName());
        patient.setHospital(hospital);
        return patient;
    }

    public PatientRandomResponseDto patientToResponse(Patient patient) {
        PatientRandomResponseDto patientDto = new PatientRandomResponseDto();
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        patientDto.setAge(patient.getAge());
        patientDto.setGender(patient.getGender());
        patientDto.setHospitalName(patient.getHospital().getName());
        AppointmentForPatientRandomResponseDto appointment = new AppointmentForPatientRandomResponseDto();
        if (patient.getAppointment() != null) {
            appointment.setDepartmentName(patient.getAppointment().getDoctor().getDepartment().getName());
            appointment.setDoctorNumber(patient.getAppointment().getDoctor().getDoctorNumber());
            appointment.setAppointmentDateTime(patient.getAppointment().getDateTime());
            patientDto.setAppointment(appointment);
        }
        return patientDto;
    }
}
