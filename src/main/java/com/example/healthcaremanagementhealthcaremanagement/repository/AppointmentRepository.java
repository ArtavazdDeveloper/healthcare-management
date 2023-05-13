package com.example.healthcaremanagementhealthcaremanagement.repository;

import com.example.healthcaremanagementhealthcaremanagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
