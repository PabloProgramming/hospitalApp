package com.app.hospital.model;

import com.app.hospital.model.favorites.DoctorFav;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    private Long doctorNumber;
    private String name;
    private String surname;
    @ManyToOne
    @JoinColumn (name = "workingDepartment")
    private Department department;
    @OneToOne(mappedBy = "doctor")
    @JsonIgnore
    private DoctorFav doctorFav;
    @ManyToMany (mappedBy = "doctors")
    private List<Patient> patient;

}
