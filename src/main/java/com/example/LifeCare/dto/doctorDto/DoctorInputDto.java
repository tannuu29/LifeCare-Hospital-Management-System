package com.example.LifeCare.dto.doctorDto;

import com.example.LifeCare.enums.Gender;
import com.example.LifeCare.enums.Specialisation;
import lombok.Data;

@Data
public class DoctorInputDto {
    private String name;
    private Long mobile;
    private String email;
    private Gender gender;
    private Specialisation specialisation;
    private Long salary;
}
