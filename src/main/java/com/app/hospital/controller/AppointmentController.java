package com.app.hospital.controller;

import com.app.hospital.model.Appointment;
import com.app.hospital.model.dto.appointment.AppointmentRequestDto;
import com.app.hospital.model.dto.appointment.AppointmentResponseDto;
import com.app.hospital.model.dto.appointment.AppointmentForDoctorResponseDto;
import com.app.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/doctor/{doctorNumber}")
    private ResponseEntity<List<AppointmentForDoctorResponseDto>> getDoctorAppointments(@PathVariable Long doctorNumber) {
        return ResponseEntity.ok(appointmentService.findDoctorAppointments(doctorNumber));
    }

    @GetMapping("/{appointmentId}")
    private ResponseEntity<Optional<Appointment>> getAppointmentInfo(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.findAppointment(appointmentId));
    }

    @GetMapping("/patient/{patientId}")
    private ResponseEntity<AppointmentResponseDto> getAppointmentByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(appointmentService.findAppointmentByPatient(patientId));
    }

    @PostMapping
    private ResponseEntity<AppointmentResponseDto> bookAnAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) {
        return ResponseEntity.ok(appointmentService.bookAnAppointment(appointmentRequestDto));
    }


}
