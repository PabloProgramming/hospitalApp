package com.app.hospital.model.favorites;
import com.app.hospital.model.Doctor;
import com.app.hospital.model.Patient;
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
public class DoctorFav {

    @GeneratedValue (strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @OneToOne
    @JoinColumn (name = "doctorId")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn (name = "patientId")
    private Patient patient;

}
