package com.agus.hospital.controller;

import com.agus.hospital.entity.Appointment;
import com.agus.hospital.entity.Speciality;
import com.agus.hospital.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class Controller {

    @Autowired
    private SpecialityService service;

    @GetMapping
    public List<Speciality> getAllSpecialities(){
        return service.findAllSpecialities();
    }
    @PostMapping("create/speciality")
    public Speciality createSpeciality(@RequestBody Speciality speciality){
        return service.createSpeciality(speciality);
    }
    @PostMapping("create/appointment")
    public Speciality createAppointment(@RequestBody Appointment appointment){
        return service.createAppointment(appointment);
    }
    @DeleteMapping("delete/speciality")
    public void deleteSpeciality(@RequestBody Speciality speciality){
        service.deleteSpeciality(speciality);
    }
    @DeleteMapping("delete/appointment")
    public void deleteAppointment(@RequestBody Appointment appointment){
        service.deleteAppointment(appointment);

    }

@PutMapping(path = "/update/{id}")
public void updateSpeciality(
        @PathVariable("id") Long id,
        @RequestParam( required = false) String name,
        @RequestParam( required = false) String physician_in_charge
){service.updateSpeciality(id,name,physician_in_charge);

}
    @PutMapping(path = "/update/appointment/{id}")
    public void updateAppointment(
            @PathVariable("id") Long id ,
            @RequestParam( required = false) String dateAppointments

    ){service.updateAppointment(id,dateAppointments);

    }

}
