package com.example.LifeCare.entity;

import com.example.LifeCare.enums.Gender;
import com.example.LifeCare.enums.Symptoms;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Patient {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long mobile;
    private String email;
    private Gender gender;
    private Symptoms symptoms;
    private String medicalHistory;
}
