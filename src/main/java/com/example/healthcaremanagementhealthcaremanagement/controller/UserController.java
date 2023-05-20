package com.example.healthcaremanagementhealthcaremanagement.controller;

import com.example.healthcaremanagementhealthcaremanagement.entity.User;
import com.example.healthcaremanagementhealthcaremanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user) {
        String password = user.getPassword();
        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());
        if (userFromDB.isEmpty()) {
            String encoderPassword = passwordEncoder.encode(password);
            user.setPassword(encoderPassword);
            userRepository.save(user);
        }
        return "redirect:/";
    }
}
