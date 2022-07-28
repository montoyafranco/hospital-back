package com.agus.hospital.service;

import com.agus.hospital.entity.Appointment;
import com.agus.hospital.entity.Speciality;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SpecialityService {
    Speciality createSpeciality(Speciality speciality);

    Speciality createAppointment(Appointment appointment);

    void deleteAppointment(Appointment appointment );

    void deleteSpeciality(Speciality speciality);

    List<Speciality> findAllSpecialities();
}
