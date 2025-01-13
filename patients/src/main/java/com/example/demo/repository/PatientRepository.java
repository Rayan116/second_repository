package com.example.demo.repository;

import com.example.demo.dto.UserPatientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<UserPatientDto, Long> {
    @Query("delete from Patient as pt where pt.email = :email")
    @Modifying
    void deletePatients(@Param(value = "email") String email);

    UserPatientDto getPatientByEmail(String email);

    UserPatientDto getPatientById(Long id);
}