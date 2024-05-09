package com.app.hospital.model.dto.docFav;

import com.app.hospital.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorFavRequestDto {

    private Long doctorNumber;
    private Long patientId;
}
