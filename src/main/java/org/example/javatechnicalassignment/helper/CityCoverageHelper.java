package org.example.javatechnicalassignment.helper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityCoverageHelper
{

    public List<String> cityList = new ArrayList<>();

//    public CityCoverageHelper()
//    {
//        cityList.add("Delhi");
//        cityList.add("Noida");
//        cityList.add("Faridabad");
//    }
    @Bean
    private List<String> addCities()
    {
        cityList.add("Delhi");
        cityList.add("Noida");
        cityList.add("Faridabad");
        return cityList;
    }
}
