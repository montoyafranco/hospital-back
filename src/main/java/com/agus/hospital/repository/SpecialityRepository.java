package com.agus.hospital.repository;

import com.agus.hospital.entity.Appointment;
import com.agus.hospital.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
}
