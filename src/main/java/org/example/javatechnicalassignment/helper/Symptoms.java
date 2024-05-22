package org.example.javatechnicalassignment.helper;

public class Symptoms
{
     public static String doctorSpecialityFromSymptom(String symptom)
     {
         if(symptom.equalsIgnoreCase("Tissue injuries") || symptom.equalsIgnoreCase("Arthritis") || symptom.equalsIgnoreCase("Back Pain"))
         {
             return "Orthopedic";
         }
         else if(symptom.equalsIgnoreCase("Dysmenorrhea"))
         {
             return "Gynecology";
         }
         else if(symptom.equalsIgnoreCase("Skin infection") || symptom.equalsIgnoreCase("Skin burn"))
         {
             return "Dermatology";
         }
         else if(symptom.equalsIgnoreCase("Ear pain") || symptom.equalsIgnoreCase("Eye pain"))
         {
             return "ENT";
         }
         else
         {
             return null;
         }

      }
}
