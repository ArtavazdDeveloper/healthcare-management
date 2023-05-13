package com.example.healthcaremanagementhealthcaremanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 4, max =30, message = "Name should be between 4 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotBlank
    @NotEmpty(message = "Surname should not be empty!")
    @Size(min = 4, max = 30, message = "Surname should be between 4 and 30 characters")
    @Column(name = "surname")
    private String surname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirthday;

}
