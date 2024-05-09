package com.app.hospital.model.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentForPatientRandomResponseDto {

    private String departmentName;
    private Long doctorNumber;
    private String appointmentDateTime;
}
