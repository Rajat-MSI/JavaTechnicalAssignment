package org.example.javatechnicalassignment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.javatechnicalassignment.helper.CityCoverageHelper;
import org.example.javatechnicalassignment.helper.MessageResponse;
import org.example.javatechnicalassignment.payload.DoctorDto;
import org.example.javatechnicalassignment.payload.PatientDto;
import org.example.javatechnicalassignment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @Autowired
    private CityCoverageHelper cityCoverageHelper;

    @PostMapping("/patient")
    public ResponseEntity<PatientDto> addPatient(@Valid @RequestBody PatientDto patientDto)
    {
        PatientDto addedPatientDto = patientService.addPatient(patientDto);
        return new ResponseEntity<>(addedPatientDto, HttpStatus.CREATED);
    }

    @GetMapping("/patient/suggest-doctor/{patientId}")
    public ResponseEntity<List<DoctorDto>> suggestDoctor(@PathVariable int patientId)
    {
        List<DoctorDto> doctorDtoList = patientService.suggestDoctor(patientId);
        return new ResponseEntity<>(doctorDtoList,HttpStatus.OK);
    }

    @GetMapping("/patient")
    public ResponseEntity<List<PatientDto>> getPatientList()
    {
        return new ResponseEntity<>(patientService.patientList(),HttpStatus.OK);
    }

    @DeleteMapping("/patient/{patientId}")
    public ResponseEntity<MessageResponse> deletePatient(@PathVariable int patientId)
    {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>(new MessageResponse("Patient removed",true),HttpStatus.OK);
    }

}
