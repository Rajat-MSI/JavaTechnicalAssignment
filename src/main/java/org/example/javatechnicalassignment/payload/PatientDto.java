package org.example.javatechnicalassignment.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientDto
{
    int patientId;
    @NotBlank
    @Size(message = "should be at least 3 characters",min = 3)
    String patientName;
    @NotBlank
    @Size(message = "should be at max 20 characters",max = 20)
    String patientCity;
    @NotBlank
    @Pattern(message = "should be a valid email address",regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    String patientEmail;
    @NotBlank
    @Size(message = "should be at least 10 numbers",max = 10)
    String patientPhoneNumber;
    @NotBlank
    String patientSymptom;
}