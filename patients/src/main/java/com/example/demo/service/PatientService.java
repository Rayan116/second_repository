package com.example.demo.service;

import com.example.demo.dto.UserPatientDto;
import com.example.demo.model.Patient;

import java.util.List;

public interface PatientService {
     List<UserPatientDto> getAllPatients();
     UserPatientDto getPatientById(Long id);
    UserPatientDto getPatientByEmail(String email);
     UserPatientDto updatePatient(UserPatientDto patient);
    UserPatientDto addPatient(UserPatientDto patient);
     void deletePatient(String email);

}
