package com.example.LifeCare.repository;

import com.example.LifeCare.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {
}
