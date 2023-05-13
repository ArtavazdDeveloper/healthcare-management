package com.example.healthcaremanagementhealthcaremanagement.repository;

import com.example.healthcaremanagementhealthcaremanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
