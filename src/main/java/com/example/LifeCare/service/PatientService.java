package com.example.LifeCare.service;

import com.example.LifeCare.dto.patientDto.PatientInputDto;
import com.example.LifeCare.dto.patientDto.PatientOutputDto;
import com.example.LifeCare.entity.Patient;
import com.example.LifeCare.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public List<PatientOutputDto> getAllPatient(){
        List<Patient> patients = patientRepo.findAll();
        List<PatientOutputDto> dtos = new ArrayList<>();

        for(Patient patient : patients){
            dtos.add(convertToDto(patient));
        }
        return dtos;
    }

    public PatientOutputDto getPatient(Long id){
        Patient patient = patientRepo.findById(id).orElse(null);
        if (patient!=null){
            return convertToDto(patient);
        }
        else {
            return null;
        }
    }

    public PatientOutputDto addPatient(PatientInputDto patientInputDto){
        System.out.println("add patient");
        return convertToDto(patientRepo.save(savePatient(patientInputDto)));
    }

    public PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto){
        Patient patient = patientRepo.findById(id).orElse(null);
        if (patient!=null){
            patient= savePatient(patientInputDto);
            patient.setId(id);
            return convertToDto(patientRepo.save(patient));
        }
        else {
            return null;
        }
    }

    public String removePatient(Long id){
        Patient patient = patientRepo.findById(id).orElse(null);
        if (patient!=null){
            patientRepo.deleteById(id);
            return "Patient " + patient.getName() + " removed successfully.";
        }
        else {
            return null;
        }
    }

    private PatientOutputDto convertToDto(Patient patient){
        PatientOutputDto dto = new PatientOutputDto();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        dto.setMobile(patient.getMobile());
        dto.setGender(patient.getGender());
        dto.setSymptoms(patient.getSymptoms());
        dto.setMedicalHistory(patient.getMedicalHistory());
        return dto;
    }

    public Patient savePatient(PatientInputDto patientInputDto){
        Patient patient = new Patient();
        patient.setName(patientInputDto.getName());
        patient.setEmail(patientInputDto.getEmail());
        patient.setMobile(patientInputDto.getMobile());
        patient.setGender(patientInputDto.getGender());
        patient.setSymptoms(patientInputDto.getSymptoms());
        patient.setMedicalHistory(patientInputDto.getMedicalHistory());
        System.out.println("save patient");
        return patient;
    }
}
