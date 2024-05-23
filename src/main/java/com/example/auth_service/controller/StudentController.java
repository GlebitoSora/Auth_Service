package com.example.auth_service.controller;

import com.example.auth_service.entity.Lesson;
import com.example.auth_service.entity.ModularDiary;
import com.example.auth_service.entity.Student;
import com.example.auth_service.entity.Tutor;
import com.example.auth_service.repository.LessonRepository;
import com.example.auth_service.repository.ModularDiaryRepository;
import com.example.auth_service.repository.StudentRepository;
import com.example.auth_service.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final TutorRepository tutorRepository;
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;
    private final ModularDiaryRepository modularDiaryRepository;
    @GetMapping("/get-lessons/{group}")
    public List<Lesson> getLessons(@PathVariable String group){
        return lessonRepository.findByGroup(group);
    }
    @GetMapping("/get-tutor-lessons/{name}")
    public List<Lesson> getTutorLessons(@PathVariable String name){
        Tutor tutor = tutorRepository.findByName(name);
        return lessonRepository.findByTutorId(tutor.getId());
    }
    @GetMapping("/get-modular-diary/{name}")
    public List<ModularDiary> getModularDiary(@PathVariable String name){
        Student student = studentRepository.findByName(name);
        return modularDiaryRepository.findByStudent(student);
    }
}
