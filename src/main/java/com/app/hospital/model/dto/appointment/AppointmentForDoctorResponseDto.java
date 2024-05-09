package com.app.hospital.model.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentForDoctorResponseDto {

    private String doctorName;
    private String departmentName;
    private Long appointmentId;
    private String dateTime;
    private Long patientId;
    private String patientNameSurname;
    private int patientAge;
    private String patientGender;

}
