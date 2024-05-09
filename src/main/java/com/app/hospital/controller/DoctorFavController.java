package com.app.hospital.controller;

import com.app.hospital.model.Doctor;
import com.app.hospital.model.dto.docFav.DoctorFavRequestDto;
import com.app.hospital.model.dto.docFav.DoctorFavResponseDto;
import com.app.hospital.model.favorites.DoctorFav;
import com.app.hospital.service.DoctorFavService;
import com.app.hospital.service.HospitalService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourites")
public class DoctorFavController {

    @Autowired
    private DoctorFavService doctorFavService;


    @GetMapping("doctor/{patientId}")
    private ResponseEntity<List<DoctorFav>> getFavouritesByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(doctorFavService.getFavByPatientId(patientId));
    }


    @PostMapping
    private ResponseEntity<DoctorFavResponseDto> SaveFavDoctorsImproved(@RequestBody DoctorFavRequestDto doctorFavRequestDto) {
        return ResponseEntity.ok(doctorFavService.saveFavDtoImproved(doctorFavRequestDto));
    }


}
