package org.example.javatechnicalassignment.exception;

import org.example.javatechnicalassignment.helper.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageResponse> resourceNotFoundExceptionHandler(
            ResourceNotFoundException exception
    )
    {
//        System.out.println(exception.getMessage());
        return new ResponseEntity<>(new MessageResponse(exception.getMessage(),false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException exception
    )
    {
        Map<String,String> map = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(e ->
        {
            String fieldName = ((FieldError) e).getField();
            String message = e.getDefaultMessage();
            map.put(fieldName,message);

        });
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }
}
