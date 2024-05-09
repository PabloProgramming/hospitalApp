package com.app.hospital.model;

import com.app.hospital.model.favorites.DoctorFav;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "hospital")
    private Hospital hospital;
    @OneToOne(mappedBy = "patient")
    @JsonIgnore
    private Appointment appointment;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<DoctorFav> doctorFav;
    @ManyToMany
    private List<Doctor> doctors;
}
