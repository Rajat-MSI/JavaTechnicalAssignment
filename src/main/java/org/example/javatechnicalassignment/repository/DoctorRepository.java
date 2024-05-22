package org.example.javatechnicalassignment.repository;

import org.example.javatechnicalassignment.entity.Doctor;
import org.example.javatechnicalassignment.payload.DoctorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>
{
    List<Doctor> findDoctorByDoctorCityAndDoctorSpeciality(String doctorCity,String doctorSpeciality);
}
