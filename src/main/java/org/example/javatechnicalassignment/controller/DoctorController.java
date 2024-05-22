package org.example.javatechnicalassignment.controller;

import jakarta.validation.Valid;
import org.example.javatechnicalassignment.helper.MessageResponse;
import org.example.javatechnicalassignment.payload.DoctorDto;
import org.example.javatechnicalassignment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class DoctorController
{
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor")
    public ResponseEntity<DoctorDto> addDoctor(@Valid @RequestBody DoctorDto doctorDto)
    {
        DoctorDto addedDoctorDto = doctorService.addDoctor(doctorDto);
        return new ResponseEntity<>(addedDoctorDto,HttpStatus.CREATED);
    }

    @GetMapping("/doctor")
    public ResponseEntity<List<DoctorDto>> getDoctorList()
    {
        return new ResponseEntity<>(doctorService.doctorList(),HttpStatus.OK);
    }

    @DeleteMapping("/doctor/{doctorId}")
    public ResponseEntity<MessageResponse> removeDoctor(@PathVariable int doctorId)
    {
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>(new MessageResponse("Doctor removed",true),HttpStatus.OK);
    }

    @GetMapping("test")
    public ResponseEntity<MessageResponse> test()
    {
        return new ResponseEntity<>(new MessageResponse("working",true),HttpStatus.OK);
    }
}
