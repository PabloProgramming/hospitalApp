package com.app.hospital.model.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentRequestDto {

    private Long doctorNumber;
    private Long patientId;
    private String dateTime;
}
