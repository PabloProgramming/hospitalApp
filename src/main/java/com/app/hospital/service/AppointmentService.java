package com.app.hospital.service;

import com.app.hospital.model.Appointment;
import com.app.hospital.model.dto.appointment.AppointmentRequestDto;
import com.app.hospital.model.dto.appointment.AppointmentResponseDto;
import com.app.hospital.model.dto.appointment.AppointmentForDoctorResponseDto;
import com.app.hospital.repository.AppointmentRepository;
import com.app.hospital.service.mapper.AppointmentMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {


    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private DepartmentService departmentService;


    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }


    public Optional<Appointment> findAppointment(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);

    }

    @SneakyThrows
    public AppointmentResponseDto findAppointmentByPatient(Long patientId) {
        Optional<Appointment> appointmentOptional = appointmentRepository.getAppointmentByPatientId(patientId);
        if (appointmentOptional.isPresent()) {
            return appointmentMapper.entityToResponseDto(appointmentOptional.get());
        }
        throw new Exception();

    }

    public List<AppointmentForDoctorResponseDto> findDoctorAppointments(Long doctorNumber) {
        List<Appointment> appointmentList = appointmentRepository.getAppointmentsByDoctorDoctorNumber(doctorNumber);
        return appointmentMapper.entitiesToResponseDtoForDoctors(appointmentList);
    }

    public AppointmentResponseDto bookAnAppointment(AppointmentRequestDto appointmentRequestDto) {
        Appointment appointment = appointmentMapper.requestDtoToEntity(appointmentRequestDto);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.entityToResponseDto(savedAppointment);
    }


}

