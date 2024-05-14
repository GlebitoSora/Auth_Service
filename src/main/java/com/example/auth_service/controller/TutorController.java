package com.example.auth_service.controller;

import com.example.auth_service.entity.Student;
import com.example.auth_service.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tutor")
public class TutorController {
    private final StudentRepository studentRepository;

    @GetMapping("/get-students")
    public List<Student> getAllStudent(@RequestParam String groupOfStudents) {
        try{
            return studentRepository.findByGroup(groupOfStudents);
        } catch (Exception e){
            return null;
        }
    }
}