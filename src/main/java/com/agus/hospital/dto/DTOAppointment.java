package com.agus.hospital.dto;

import lombok.Data;

@Data
public class DTOAppointment {

    private String name;
    private int age;
    private Long identification_number;
    private String dateAppointments;
    private Long number_of_appointments = 1L;
    private Long fkSpecialityId;

}
