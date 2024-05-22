package org.example.javatechnicalassignment.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DoctorDto
{
    int doctorId;
    @NotBlank
    @Size(message = "should be at least 3 characters",min = 3)
    String doctorName;
    @NotBlank
    @Size(message = "should be at max 20 characters",max = 20)
    String doctorCity;
    @NotBlank
    @Pattern(message = "should be a valid email address",regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    String doctorEmail;
    @NotBlank
    @Size(message = "should be at least 10 numbers",max = 10)
    String doctorPhoneNumber;
    @NotBlank
    String doctorSpeciality;
}