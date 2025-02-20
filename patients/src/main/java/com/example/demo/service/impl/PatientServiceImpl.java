package com.example.demo.service.impl;

import com.example.demo.dto.UserPatientDto;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<UserPatientDto> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public UserPatientDto getPatientById(Long id) {
        return patientRepository.getPatientById(id);
    }

    @Override
    public UserPatientDto getPatientByEmail(String email) {
        return patientRepository.getPatientByEmail(email);
    }

    @Override
    public UserPatientDto updatePatient(UserPatientDto patient) {
        return patientRepository.save(patient);
    }

    @Override
    public UserPatientDto addPatient(UserPatientDto patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(String email) {
        patientRepository.deletePatients(email);
    }
}
