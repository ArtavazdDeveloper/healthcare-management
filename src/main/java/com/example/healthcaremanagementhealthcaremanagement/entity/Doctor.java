package com.example.healthcaremanagementhealthcaremanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 4, max =30, message = "Name should be between 4 and 30 characters " )
    @Column(name = "name")
    private String name;

    @NotBlank
    @NotEmpty(message = "Surname should not be empty!")
    @Size(min = 4, max = 30, message = "Surname should be between 4 and 30 characters" )
    @Column(name = "surname")
    private String surname;

    @NotBlank
    @NotEmpty(message = "Mail should not be empty!")
    @Size(min = 4, max = 30, message = "Mail should be between 4 and 30 characters" )
    private String email;

    @NotBlank
    @NotEmpty(message = "Specialty should not be empty!")
    @Size(min = 4, max = 30, message = "Specialty should be between 4 and 30 characters" )
    private String specialty;

    @NotBlank
    @NotEmpty(message = "Number should not be empty!")
    @Size(min = 8, max = 16, message = "Number should be between 4 and 30 characters" )
    @Column(name = "phone_number")
    private String phone_number;

    private String profilePic;
}
