package com.app.hospital.model.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentResponseDto {

    private Long appointmentId;
    private String doctorName;
    private String patientName;
    private String dateTime;
    private String departmentName;
}
