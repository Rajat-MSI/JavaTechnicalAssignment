package org.example.javatechnicalassignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int patientId;
    String patientName;
    String patientCity;
    String patientEmail;
    String patientPhoneNumber;
    String patientSymptom;
}
