package com.app.hospital.service.mapper;

import com.app.hospital.model.dto.docFav.DoctorFavRequestDto;
import com.app.hospital.model.dto.docFav.DoctorFavResponseDto;
import com.app.hospital.model.favorites.DoctorFav;
import com.app.hospital.service.DoctorService;
import com.app.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorFavMapper {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    public DoctorFav requestDtoToEntity(DoctorFavRequestDto doctorFavRequestDto) {
        DoctorFav doctorFav = new DoctorFav();
        doctorFav.setDoctor(doctorService.findDoctorById(doctorFavRequestDto.getDoctorNumber()));
        doctorFav.setPatient(patientService.findPatientById(doctorFavRequestDto.getPatientId()));
        return doctorFav;
    }

    public DoctorFavResponseDto entityToResponseDto(DoctorFav doctorFav) {
        DoctorFavResponseDto doctorFavResponseDto = new DoctorFavResponseDto();
        doctorFavResponseDto.setFavId(doctorFav.getId());
        doctorFavResponseDto.setDoctorNumber(doctorFav.getDoctor().getDoctorNumber());
        doctorFavResponseDto.setNameSurname(doctorFav.getDoctor().getName() + " " + doctorFav.getDoctor().getSurname());
        doctorFavResponseDto.setDepartmentName(doctorFav.getDoctor().getDepartment().getName());
        return doctorFavResponseDto;
    }
}
