package com.agus.hospital.service;

import com.agus.hospital.entity.Appointment;
import com.agus.hospital.entity.Speciality;
import com.agus.hospital.repository.AppointmentRepository;
import com.agus.hospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        Speciality specialityToBeDeleted = specialityRepository.findById(speciality.getIdSpeciality()).get();
        if (specialityToBeDeleted.getAppointmentList().size() >= 0){
            specialityToBeDeleted.getAppointmentList().forEach(appointment -> appointmentRepository.deleteById(appointment.getId()) );

        }
        specialityRepository.deleteById(speciality.getIdSpeciality());
    }

    @Override
    public List<Speciality> findAllSpecialities() {
        return specialityRepository.findAll();
    }

    @Override
    @Transactional
    public void updateSpeciality(Long idSpeciality, String name, String physician_in_charge) {
        Optional<Speciality> speciality = specialityRepository.findById(idSpeciality);

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
