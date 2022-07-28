package com.agus.hospital.dto;

import com.agus.hospital.entity.Appointment;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
public class DTOSpeciality {
    private Long id;
    private String name;   // max 100char  min 5
    private String physician_in_charge; // max 45 char  min 10
    private List<Appointment> appointmentList = new ArrayList<>();

}
