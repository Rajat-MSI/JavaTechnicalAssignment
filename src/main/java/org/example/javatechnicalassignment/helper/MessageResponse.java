package org.example.javatechnicalassignment.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponse
{
    private String message;
    private boolean success;
}
