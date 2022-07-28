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
    private String name;
    private int age;
    private Long identification_number;

    private Long number_of_appointments = 1L;
    private Long fkSpecialityId;


}
