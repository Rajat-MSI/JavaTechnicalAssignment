package org.example.javatechnicalassignment.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException
{
    String resourceName;
    String resourceFieldName;
    long resourceFieldValue;
    String resourceMessage;

    public ResourceNotFoundException(String resourceName,String resourceFieldName,long resourceFieldValue) {
        super(String.format("%s not found with %s %s", resourceName, resourceFieldName, resourceFieldValue));
        this.resourceName = resourceName;
        this.resourceFieldName = resourceFieldName;
        this.resourceFieldValue = resourceFieldValue;

    }

    public ResourceNotFoundException(String resourceMessage)
    {
        super(resourceMessage);
        this.resourceMessage = resourceMessage;
    }
}
