package com.app.hospital.model.dto.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DoctorDto {

    private Long doctorNumber;
    private String name;
    private String surname;
    private Long departmentId;
}
