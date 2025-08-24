package com.example.LifeCare.service;

import com.example.LifeCare.dto.doctorDto.DoctorInputDto;
import com.example.LifeCare.dto.doctorDto.DoctorOutputDto;
import com.example.LifeCare.entity.Doctor;
import com.example.LifeCare.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    public DoctorOutputDto getDoctor(Long id){
        Doctor doctor = doctorRepo.findById(id).orElse(null);
        if(doctor!=null) {
            return convertToDto(doctor);
        }
        else{
            return null;
        }
    }

    public List<DoctorOutputDto> getAllDoctors(){
        List<Doctor> doctors = doctorRepo.findAll();
        List<DoctorOutputDto> dtos = new ArrayList<>();

        for(Doctor doctor : doctors){
            dtos.add(convertToDto(doctor));
        }
        return dtos;
    }

    public DoctorOutputDto addDoctor(DoctorInputDto doctorInputDto){
        return convertToDto(doctorRepo.save(saveDoctor(doctorInputDto)));
    }

    public DoctorOutputDto updateDoctor(Long id, DoctorInputDto doctorInputDto){
        Doctor doctor = doctorRepo.findById(id).orElse(null);
        if (doctor!=null){
            doctor= saveDoctor(doctorInputDto);
            doctor.setId(id);
            return convertToDto(doctorRepo.save(doctor));
        }
        else{
            return null;
        }

    }

    public String removeDoctor(Long id){
        Doctor doctor = doctorRepo.findById(id).orElse(null);
        if(doctor!=null) {
            doctorRepo.findById(id);
            return "Doctor " + doctor.getName() + " removed successfully.";
        }
        else{
            return null;
        }
    }

    private DoctorOutputDto convertToDto(Doctor doctor){
        DoctorOutputDto dto = new DoctorOutputDto();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setEmail(doctor.getEmail());
        dto.setMobile(doctor.getMobile());
        dto.setSpecialisation(doctor.getSpecialisation());
        dto.setSalary(doctor.getSalary());
        dto.setGender(doctor.getGender());
        return dto;
    }
    public Doctor saveDoctor(DoctorInputDto doctorInputDto){
        Doctor doctor = new Doctor();
        doctor.setName(doctorInputDto.getName());
        doctor.setMobile(doctorInputDto.getMobile());
        doctor.setEmail(doctorInputDto.getEmail());
        doctor.setGender(doctorInputDto.getGender());
        doctor.setSpecialisation(doctorInputDto.getSpecialisation());
        doctor.setSalary(doctorInputDto.getSalary());
        return doctor;
    }
}
