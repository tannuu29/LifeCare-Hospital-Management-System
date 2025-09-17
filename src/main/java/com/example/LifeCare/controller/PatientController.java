package com.example.LifeCare.controller;

import com.example.LifeCare.dto.patientDto.PatientInputDto;
import com.example.LifeCare.dto.patientDto.PatientOutputDto;
import com.example.LifeCare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<List<PatientOutputDto>> getAllPatient(){
        return new ResponseEntity<>(patientService.getAllPatient(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientOutputDto> getPatient(@PathVariable Long id){
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/add")
    public ResponseEntity<PatientOutputDto> addPatient(@RequestBody PatientInputDto patientInputDto){
        System.out.println("conroller");
        return new ResponseEntity<>(patientService.addPatient(patientInputDto), HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<PatientOutputDto> updatePatient(@RequestParam Long id, @RequestBody PatientInputDto patientInputDto){
        return new ResponseEntity<>(patientService.updatePatient(id, patientInputDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public String removePatient(@RequestParam Long id){
        return patientService.removePatient(id);
    }
}
