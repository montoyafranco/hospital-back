package com.agus.hospital.service;

import com.agus.hospital.entity.Appointment;
import com.agus.hospital.entity.Speciality;
import com.agus.hospital.repository.AppointmentRepository;
import com.agus.hospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    @Transactional
    public void updateSpeciality(Long id, String name, String physician_in_charge) {
        Speciality speciality = specialityRepository.findById(id).get();
        speciality.setName(name);
        speciality.setPhysician_in_charge(physician_in_charge);

    }









//        if(physicianInCharge != null) {
//            checkSpecialtyPhysician(physicianInCharge);
//            specialty.setPhysicianInCharge(physicianInCharge);
//        }



//    public Specialty updateSpecialty(Long specialtyId, String name, String physicianInCharge) {
//        Specialty specialty = getSpecialty(specialtyId);
//        if(name != null) {
//            checkSpecialtyName(name);
//            specialty.setName(name);
//        }
//
//        if(physicianInCharge != null) {
//            checkSpecialtyPhysician(physicianInCharge);
//            specialty.setPhysicianInCharge(physicianInCharge);
//        }
//
//        return specialty;
//    }
}
