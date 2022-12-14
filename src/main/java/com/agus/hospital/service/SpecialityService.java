package com.agus.hospital.service;

import com.agus.hospital.entity.Appointment;
import com.agus.hospital.entity.Speciality;

import java.util.List;


public interface SpecialityService {
    Speciality createSpeciality(Speciality speciality);

    Speciality createAppointment(Appointment appointment);

    void deleteAppointment(Appointment appointment );

    void deleteSpeciality(Speciality speciality);

    List<Speciality> findAllSpecialities();

    void updateSpeciality(Long idSpeciality, String name, String physician_in_charge);

    void updateAppointment(Long id, String dateAppointments);
}
