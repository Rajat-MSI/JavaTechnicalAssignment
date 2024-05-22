package org.example.javatechnicalassignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int doctorId;
    String doctorName;
    String doctorCity;
    String doctorEmail;
    String doctorPhoneNumber;
    String doctorSpeciality;
}
