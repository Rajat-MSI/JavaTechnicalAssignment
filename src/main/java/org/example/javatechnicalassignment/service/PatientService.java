package org.example.javatechnicalassignment.service;

import org.example.javatechnicalassignment.payload.DoctorDto;
import org.example.javatechnicalassignment.payload.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService
{
    PatientDto addPatient(PatientDto patientDto);
    List<PatientDto> patientList();
    void deletePatient(int patientId);
    List<DoctorDto> suggestDoctor(int patientId);
}
