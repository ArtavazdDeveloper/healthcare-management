package com.example.healthcaremanagementhealthcaremanagement.controller;



import com.example.healthcaremanagementhealthcaremanagement.entity.Doctor;
import com.example.healthcaremanagementhealthcaremanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Value("{healthcare.upload.image.path}")
    private String imageUploadPate;

    @GetMapping("/doctors")
    public String doctorPage(ModelMap modelMap) {
        List<Doctor> all = doctorRepository.findAll();
        modelMap.addAttribute("doctors", all);
        return "doctors";
    }

    @GetMapping("/doctors/add")
    public String addDoctorPage() {
        return "addDoctor";
    }

    @PostMapping("/doctors/add")
    public String addDoctors(@ModelAttribute Doctor doctor,
                             @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = null;
        if (multipartFile != null && multipartFile.getSize() > 0) {
            fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPate + fileName);
            multipartFile.transferTo(file);
            doctor.setProfilePic(fileName);
        }
        doctorRepository.save(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/remove")
    public String removeDoctor(@RequestParam("id") int id) {
        doctorRepository.deleteById(id);
        return "redirect:/doctors";
    }
}
