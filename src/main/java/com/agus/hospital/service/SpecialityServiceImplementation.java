package com.agus.hospital.service;

import com.agus.hospital.entity.Appointment;
import com.agus.hospital.entity.Speciality;
import com.agus.hospital.repository.AppointmentRepository;
import com.agus.hospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImplementation implements SpecialityService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public Speciality createSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Speciality createAppointment(Appointment appointment) {
        Speciality speciality = specialityRepository.findById(appointment.getFkSpecialityId()).get();
        speciality.addAppointment(appointment);
        return specialityRepository.save(speciality);


    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        appointmentRepository.deleteById(appointment.getId());

    }

    @Override
    public void deleteSpeciality(Speciality speciality) {
        Speciality specialityToBeDeleted = specialityRepository.findById(speciality.getId()).get();
        if (specialityToBeDeleted.getAppointmentList().size() >= 0){
            specialityToBeDeleted.getAppointmentList().forEach(appointment -> appointmentRepository.deleteById(appointment.getId()) );

        }
        specialityRepository.deleteById(speciality.getId());

    }

    @Override
    public List<Speciality> findAllSpecialities() {
        return specialityRepository.findAll();
    }
}
