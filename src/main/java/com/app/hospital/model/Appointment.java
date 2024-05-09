package com.app.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long number;
    private String dateTime;
    @ManyToOne
    @JoinColumn (name = "doctor")
    private Doctor doctor;
    @OneToOne
    @JoinColumn (name = "patient")
    private Patient patient;

}
