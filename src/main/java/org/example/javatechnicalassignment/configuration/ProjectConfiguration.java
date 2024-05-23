package org.example.javatechnicalassignment.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.example.javatechnicalassignment.helper.ApplicationConstant;
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

    @Bean
    public OpenAPI APIDocumentationInfo()
    {
        return new OpenAPI().info(new Info().title("Java Technical Assignment")
                .description(ApplicationConstant.API_DESCRIPTION)
                .version("v0.0.1")
                .contact(new Contact().name("Rajat Sharma").email("sharmarajat532@gmail.com").url("https://github.com/Rajat-MSI"))
                .license(new License().name("Free License").url("https://github.com/Rajat-MSI/JavaTechnicalAssignment"))
        );
    }
}
