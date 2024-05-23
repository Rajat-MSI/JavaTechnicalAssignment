package org.example.javatechnicalassignment.helper;

public class ApplicationConstant
{
    public static final String API_DESCRIPTION = "Suggest Doctor API - Functionality Description\n" +
            "The Suggest Doctor API is a core functionality within the doctor-patient management system. This API retrieves a list of doctors suitable for a patient based on their location (city) and medical concern (symptom).\n" +
            "\n" +
            "Functionality:\n" +
            "\n" +
            "Input: The API takes a single input parameter:\n" +
            "\n" +
            "patientId: Unique identifier for the patient (Long data type).\n" +
            "Process:\n" +
            "\n" +
            "The API retrieves the patient's details (including city and symptom) from the database using the provided patient ID.\n" +
            "It validates if the patient's city is within the serviceable area (predefined list: Delhi, Noida, Faridabad).\n" +
            "If not, the API returns a pre-defined message indicating the platform hasn't yet expanded to the patient's location.\n" +
            "Based on the patient's symptom, the API translates it to the corresponding doctor's speciality (e.g., Arthritis -> Orthopedic).\n" +
            "The API queries the database to find doctors matching the patient's city and the derived speciality.\n" +
            "Output:\n" +
            "\n" +
            "Success: The API returns a list of Doctor objects representing doctors practicing in the patient's city and specializing in the area relevant to the patient's symptom.\n" +
            "Edge Cases:\n" +
            "If the patient's city is outside the serviceable area: The API returns a pre-defined message indicating the platform hasn't yet expanded there.\n" +
            "If no doctors are found matching the patient's city and symptom combination: The API returns a pre-defined message indicating a lack of doctors in that location for the specific medical concern.\n" +
            "Benefits:\n" +
            "\n" +
            "Efficiently connects patients with suitable doctors based on their location and medical needs.\n" +
            "Streamlines the process of finding appropriate healthcare providers.\n" +
            "Error Handling:\n" +
            "\n" +
            "The API should implement proper error handling mechanisms to gracefully handle unexpected situations (e.g., invalid patient ID, database connection issues).\n" +
            "Additional Notes:\n" +
            "\n" +
            "This API serves as a foundational element for facilitating patient-doctor interactions within the platform.\n" +
            "Consider incorporating response codes or a dedicated error object within the response structure to signify successful retrievals versus error scenarios.";
}
