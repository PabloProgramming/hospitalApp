package com.app.hospital.model.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private String name;
    private String surname;
    private int age;
    private String gender;
    private String hospitalName;
}
