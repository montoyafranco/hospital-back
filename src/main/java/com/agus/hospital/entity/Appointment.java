package com.agus.hospital.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity(name = "Appointment")
@Table(name = "appointment")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(updatable = false, length = 45, nullable = false)
    private String name;
    @Column(updatable = false, nullable = false)
    private int age;
    @Column(updatable = false, nullable = false, unique = true)
    private Long identification_number;

    private String dateAppointments;
    private Long number_of_appointments = 1L;
    private Long fkSpecialityId;


}
