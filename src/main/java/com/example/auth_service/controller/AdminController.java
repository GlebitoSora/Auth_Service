package com.example.auth_service.controller;

import com.example.auth_service.dto.StudentDto;
import com.example.auth_service.dto.TutorDto;
import com.example.auth_service.entity.Student;
import com.example.auth_service.entity.Tutor;
import com.example.auth_service.repository.StudentRepository;
import com.example.auth_service.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository;
    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){
        if (studentRepository.existsByPhoneNumber(studentDto.getPhoneNumber())){
            return ResponseEntity.badRequest().body("Студент уже существует");
        }
        else{
            var student = Student.builder()
                    .name(studentDto.getName())
                    .group(studentDto.getGroup())
                    .phoneNumber(studentDto.getPhoneNumber())
                    .build();
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        }

    }
    @PostMapping("/add-tutor")
    public ResponseEntity<?> addTutor(@RequestBody TutorDto tutorDto){
        if (tutorRepository.existsByPhoneNumber(tutorDto.getPhoneNumber())){
            return ResponseEntity.badRequest().body("Преподаватель уже существует");
        }
        else{
            var tutor = Tutor.builder()
                    .name(tutorDto.getName())
                    .phoneNumber(tutorDto.getPhoneNumber())
                    .build();
            tutorRepository.save(tutor);
            return ResponseEntity.ok(tutor);
        }
    }
}
