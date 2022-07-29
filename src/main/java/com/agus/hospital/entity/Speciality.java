package com.agus.hospital.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Speciality")
@Table(name = "speciality")
@Data
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSpeciality;
    @Column(nullable = false, length = 100)

    private String name;   // max 100char  min 5
    @Column(nullable = false, length = 45)
    private String physician_in_charge; // max 45 char  min 10


    @OneToMany(
            cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    private List<Appointment> appointmentList = new ArrayList<>();

    public Speciality addAppointment(Appointment appointmentList){
        this.appointmentList.add(appointmentList);
        return this;
    }
}
