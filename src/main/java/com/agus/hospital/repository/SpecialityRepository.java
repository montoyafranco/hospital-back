package com.agus.hospital.repository;

import com.agus.hospital.entity.Appointment;
import com.agus.hospital.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Long> {



}
