package com.app.hospital.model.dto.docFav;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorFavResponseDto {

    private Long FavId;
    private Long doctorNumber;
    private String nameSurname;
    private String departmentName;
}
