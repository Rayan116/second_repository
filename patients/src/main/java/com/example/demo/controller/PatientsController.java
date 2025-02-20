package com.example.demo.controller;


import com.example.demo.dto.UserPatientDto;
import com.example.demo.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/patients")
@RequiredArgsConstructor
public class PatientsController {
    @Autowired
    private final PatientService patientService;

    @GetMapping
    public List<UserPatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    public void addPatient(@RequestBody UserPatientDto patient) {
        patientService.addPatient(patient);
    }

    @GetMapping("get_patient_id/{id}")
    public UserPatientDto getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("get_patient/{email}")
    public UserPatientDto getPatientByEmail(@PathVariable("email") String email) {
        return patientService.getPatientByEmail(email);
    }

    @PutMapping("update_patient")
    public void updatePatient(UserPatientDto patient) {
        patientService.updatePatient(patient);
    }

    @DeleteMapping("delete_patient/{email}")
    public void deletePatient(@PathVariable("email") String email) {
        patientService.deletePatient(email);
    }
}