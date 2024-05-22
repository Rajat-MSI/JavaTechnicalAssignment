package org.example.javatechnicalassignment.service;

import org.example.javatechnicalassignment.payload.DoctorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService
{
    DoctorDto addDoctor(DoctorDto doctorDto);
    List<DoctorDto> doctorList();
    void deleteDoctor(int doctorId);
}
