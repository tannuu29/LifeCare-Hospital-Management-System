package com.example.LifeCare.entity;

import com.example.LifeCare.enums.Symptoms;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Patient {
    @Id
    private Long id;
    private Symptoms symptoms;
    private String medicalHistory;

}
