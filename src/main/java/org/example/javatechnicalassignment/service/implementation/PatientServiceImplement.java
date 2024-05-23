package org.example.javatechnicalassignment.service.implementation;

import org.example.javatechnicalassignment.entity.Doctor;
import org.example.javatechnicalassignment.entity.Patient;
import org.example.javatechnicalassignment.exception.ResourceNotFoundException;
import org.example.javatechnicalassignment.helper.CityCoverageHelper;
import org.example.javatechnicalassignment.helper.Symptoms;
import org.example.javatechnicalassignment.payload.DoctorDto;
import org.example.javatechnicalassignment.payload.PatientDto;
import org.example.javatechnicalassignment.repository.DoctorRepository;
import org.example.javatechnicalassignment.repository.PatientRepository;
import org.example.javatechnicalassignment.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImplement implements PatientService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private CityCoverageHelper cityCoverageHelper;

    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDto.class);
    }

    @Override
    public List<PatientDto> patientList() {
        return patientRepository.findAll().stream().map(patient -> modelMapper.map(patient, PatientDto.class)).toList();
    }

    @Override
    public void deletePatient(int patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient", "patient id", patientId));
        System.out.println(patient);
        patientRepository.delete(patient);
    }

    @Override
    public List<DoctorDto> suggestDoctor(int patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient", "patient id", patientId));
        String patientCity = patient.getPatientCity();
        String patientSymptom = patient.getPatientSymptom();
//        System.out.println(cityCoverageHelper.cityList);
        if (!cityCoverageHelper.cityList.contains(patientCity)) {
//            System.out.println("City is absent");
            throw new ResourceNotFoundException("We are still waiting to expand to your location");
        }
//        System.out.println("City is present");
        String speciality = Symptoms.doctorSpecialityFromSymptom(patientSymptom);
//        System.out.println(speciality);
        if (speciality == null)
        {
            throw new ResourceNotFoundException("There isn’t any doctor present at your location for your symptom");
        }
        List<Doctor> doctorList = doctorRepository.findDoctorByDoctorCityAndDoctorSpeciality(patientCity, speciality);
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        for (Doctor doctor : doctorList)
        {
            if(doctor.getDoctorCity().equals(patientCity))
            {
                doctorDtoList.add(modelMapper.map(doctor,DoctorDto.class));
            }
        }
        if (doctorDtoList.isEmpty())
        {
            throw new ResourceNotFoundException("There isn’t any doctor present at your location for your symptom");
        }
        return doctorDtoList;
    }
}

