package com.app.hospital.service.mapper;

import com.app.hospital.model.Appointment;
import com.app.hospital.model.dto.appointment.AppointmentRequestDto;
import com.app.hospital.model.dto.appointment.AppointmentResponseDto;
import com.app.hospital.model.dto.appointment.AppointmentForDoctorResponseDto;
import com.app.hospital.service.DepartmentService;
import com.app.hospital.service.DoctorService;
import com.app.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentMapper {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DepartmentService departmentService;

    public Appointment requestDtoToEntity(AppointmentRequestDto appointmentRequestDto) {
        Appointment appointment = new Appointment();
        appointment.setDateTime(appointmentRequestDto.getDateTime());
        appointment.setDoctor(doctorService.findDoctorById(appointmentRequestDto.getDoctorNumber()));
        appointment.setPatient(patientService.findPatientById(appointmentRequestDto.getPatientId()));
        return appointment;
    }

    public AppointmentResponseDto entityToResponseDto(Appointment appointment) {
        AppointmentResponseDto appointmentResponseDto = new AppointmentResponseDto();
        appointmentResponseDto.setAppointmentId(appointment.getNumber());
        appointmentResponseDto.setDoctorName(appointment.getDoctor().getName() + " " + appointment.getDoctor().getSurname());
        appointmentResponseDto.setPatientName(appointment.getPatient().getName() + " " + appointment.getPatient().getSurname());
        appointmentResponseDto.setDateTime(appointment.getDateTime());
        appointmentResponseDto.setDepartmentName(appointment.getDoctor().getDepartment().getName());
        return appointmentResponseDto;

    }

    public List<AppointmentForDoctorResponseDto> entitiesToResponseDtoForDoctors(List<Appointment> appointmentList) {
        List<AppointmentForDoctorResponseDto> responseList = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            AppointmentForDoctorResponseDto response = entityToResponseDtoForDoctor(appointment);
            responseList.add(response);
        }
        return responseList;
    }

    public AppointmentForDoctorResponseDto entityToResponseDtoForDoctor(Appointment appointment) {
        AppointmentForDoctorResponseDto doctorAppointments = new AppointmentForDoctorResponseDto();
        doctorAppointments.setDoctorName(appointment.getDoctor().getName());
        Long departmentId = appointment.getDoctor().getDepartment().getId();
        doctorAppointments.setDepartmentName(departmentService.findDepartmentById(departmentId).getName());
        doctorAppointments.setAppointmentId(appointment.getNumber());
        doctorAppointments.setDateTime(appointment.getDateTime());
        Long patientId = appointment.getPatient().getId();
        doctorAppointments.setPatientId(patientId);
        doctorAppointments.setPatientNameSurname(appointment.getPatient().getName() + " " + appointment.getPatient().getSurname());
        doctorAppointments.setPatientAge(appointment.getPatient().getAge());
        doctorAppointments.setPatientGender(appointment.getPatient().getGender());
        return doctorAppointments;
    }
}
