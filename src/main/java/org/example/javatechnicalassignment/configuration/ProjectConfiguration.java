package org.example.javatechnicalassignment.configuration;

import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration
{
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
