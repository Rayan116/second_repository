package com.example.demo.controller;

import com.example.demo.dto.UserPatientDto;
import com.example.demo.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/patients")
@AllArgsConstructor
public class PatientsController {
    private final PatientService servicePatient;

    @GetMapping
    public List<UserPatientDto> getAllPatients() {
        return servicePatient.getAllPatients();
    }

    @PostMapping
    public void addPatient(@RequestBody UserPatientDto patient) {
        servicePatient.addPatient(patient);
    }

    @GetMapping("get_patient_id/{id}")
    public UserPatientDto getPatientById(@PathVariable("id") Long id) {
        return servicePatient.getPatientById(id);
    }

    @GetMapping("get_patient/{email}")
    public UserPatientDto getPatientByEmail(@PathVariable("email") String email) {
        return servicePatient.getPatientByEmail(email);
    }

    @PutMapping("update_patient")
    public void updatePatient(UserPatientDto patient) {
        servicePatient.updatePatient(patient);
    }

    @DeleteMapping("delete_patient/{email}")
    public void deletePatient(@PathVariable("email") String email) {
        servicePatient.deletePatient(email);
    }
}