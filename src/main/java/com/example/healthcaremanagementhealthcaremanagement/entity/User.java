package com.example.healthcaremanagementhealthcaremanagement.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 4, max =30, message = "Name should be between 4 and 30 characters " )
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname should not be empty!")
    @Size(min = 4, max =30, message = "Surname should be between 4 and 30 characters " )
    @Column(name = "surname")
    private String surname;

    @NotEmpty(message = "Mail should not be empty!")
    @Size(min = 4, max =30, message = "Mail should be between 4 and 30 characters " )
    @Column(name = "mail")
    private String email;

    @NotEmpty(message = "Password should not be empty!")
    @Size(min = 4, max =30, message = "Password should be between 4 and 30 characters " )
    @Column(name = "password")
    private String password;
}
