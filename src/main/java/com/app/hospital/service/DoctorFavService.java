package com.app.hospital.service;

import com.app.hospital.model.dto.docFav.DoctorFavRequestDto;
import com.app.hospital.model.dto.docFav.DoctorFavResponseDto;
import com.app.hospital.model.favorites.DoctorFav;
import com.app.hospital.repository.DoctorFavRepository;
import com.app.hospital.repository.DoctorRepository;
import com.app.hospital.service.mapper.DoctorFavMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorFavService {

    @Autowired
    private DoctorFavRepository doctorFavRepository;

    @Autowired
    private DoctorFavMapper doctorFavMapper;

    public DoctorFav saveFav(DoctorFav doctorFav){
        return doctorFavRepository.save(doctorFav);
    }


    public List<DoctorFav> getFavByPatientId(Long patientId){
        return doctorFavRepository.findDoctorFavsByPatientId(patientId);
    }


    public DoctorFav saveFavDto(DoctorFavRequestDto doctorFavRequestDto){
        DoctorFav doctorFav = doctorFavMapper.requestDtoToEntity(doctorFavRequestDto);
        return doctorFavRepository.save(doctorFav);

    }

    public DoctorFavResponseDto saveFavDtoImproved(DoctorFavRequestDto doctorFavRequestDto){
        DoctorFav doctorFav = doctorFavMapper.requestDtoToEntity(doctorFavRequestDto);
        DoctorFav savedFav = doctorFavRepository.save(doctorFav);
        return doctorFavMapper.entityToResponseDto(savedFav);
    }
}
