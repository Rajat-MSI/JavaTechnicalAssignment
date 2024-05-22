package org.example.javatechnicalassignment.service.implementation;

import org.example.javatechnicalassignment.entity.Doctor;
import org.example.javatechnicalassignment.exception.ResourceNotFoundException;
import org.example.javatechnicalassignment.payload.DoctorDto;
import org.example.javatechnicalassignment.repository.DoctorRepository;
import org.example.javatechnicalassignment.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImplement implements DoctorService
{
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto)
    {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor,DoctorDto.class);
    }

    @Override
    public List<DoctorDto> doctorList()
    {
        return doctorRepository.findAll().stream().map(doctor -> modelMapper.map(doctor,DoctorDto.class)).toList();
    }

    @Override
    public void deleteDoctor(int doctorId)
    {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor", "doctor id:", doctorId));
        doctorRepository.delete(doctor);
    }
}
