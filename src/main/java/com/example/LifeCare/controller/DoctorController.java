package com.example.LifeCare.controller;

import com.example.LifeCare.dto.doctorDto.DoctorInputDto;
import com.example.LifeCare.dto.doctorDto.DoctorOutputDto;
import com.example.LifeCare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public ResponseEntity<List<DoctorOutputDto>> getAllDoctors(){
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorOutputDto> getDoctor(@PathVariable Long id){
        return new ResponseEntity<>(doctorService.getDoctor(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/add")
    public ResponseEntity<DoctorOutputDto> addDoctor(@RequestBody DoctorInputDto doctorInputDto){
        return new ResponseEntity<>(doctorService.addDoctor(doctorInputDto), HttpStatusCode.valueOf(200) );
    }

    @PutMapping
    public ResponseEntity<DoctorOutputDto> updateDoctor(@RequestParam Long id, @RequestBody DoctorInputDto doctorInputDto){
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctorInputDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public String removeDoctor(@RequestParam Long id){
        return doctorService.removeDoctor(id);
    }
}
