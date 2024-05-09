package com.app.hospital.model.dto.patient;

import com.app.hospital.model.dto.appointment.AppointmentForPatientRandomResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRandomResponseDto {

    private String name;
    private String surname;
    private int age;
    private String gender;
    private String hospitalName;
    private AppointmentForPatientRandomResponseDto appointment;

}
