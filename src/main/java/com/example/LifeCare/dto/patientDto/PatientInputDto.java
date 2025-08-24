package com.example.LifeCare.dto.patientDto;

import com.example.LifeCare.enums.Gender;
import com.example.LifeCare.enums.Specialisation;
import com.example.LifeCare.enums.Symptoms;
import lombok.Data;

@Data
public class PatientInputDto {
    private String name;
    private Long mobile;
    private String email;
    private Gender gender;
    private Symptoms symptoms;
    private String medicalHistory;
}
