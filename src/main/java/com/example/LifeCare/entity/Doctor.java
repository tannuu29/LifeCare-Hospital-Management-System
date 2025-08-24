package com.example.LifeCare.entity;

import com.example.LifeCare.enums.Gender;
import com.example.LifeCare.enums.Specialisation;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long mobile;
    private String email;
    private Gender gender;
    private Specialisation specialisation;
    private Long salary;
}
