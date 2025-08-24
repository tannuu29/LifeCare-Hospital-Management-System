package com.example.LifeCare.dto.doctorDto;

import com.example.LifeCare.enums.Gender;
import com.example.LifeCare.enums.Specialisation;
import lombok.Data;

@Data
public class DoctorOutputDto {
    private Long id;
    private String name;
    private String email;
    private Long mobile;
    private Gender gender;
    private Specialisation specialisation;
    private Long salary;
}
