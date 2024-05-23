package com.example.auth_service.controller;

import com.example.auth_service.dto.*;
import com.example.auth_service.entity.*;
import com.example.auth_service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository;
    private final LessonRepository lessonRepository;
    private final AudienceRepository audienceRepository;
    private final DisciplineRepository disciplineRepository;
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
    @PostMapping("/add-lesson")
    public ResponseEntity<?> addLesson(@RequestBody LessonDto lessonDto){
        var lesson = Lesson.builder()
                .group(lessonDto.getGroup())
                .typeOfLesson(lessonDto.getTypeOfLesson())
                .audience(audienceRepository.findByAudienceNumber(lessonDto.getAudienceNumber()))
                .description(lessonDto.getDescription())
                .dateTime(lessonDto.getTime())
                .tutor(tutorRepository.findByName(lessonDto.getTutorName()))
                .discipline(disciplineRepository.findByName(lessonDto.getDisciplineName()))
                .build();
        lessonRepository.save(lesson);
        return ResponseEntity.ok(lesson);
    }
    @PostMapping("/add-audience")
    public ResponseEntity<?> addAudience(@RequestBody AudienceDto audienceDto){
        var audience = Audience.builder()
                .audienceNumber(audienceDto.getAudienceNumber())
                .building(audienceDto.getBuilding())
                .build();
        audienceRepository.save(audience);
        return ResponseEntity.ok(audience);
    }
    @PostMapping("/add-discipline")
    public ResponseEntity<?> addDiscipline(@RequestBody DisciplineDto disciplineDto){
        var discipline = Discipline.builder()
                .name(disciplineDto.getName())
                .department(disciplineDto.getDepartment())
                .build();
        disciplineRepository.save(discipline);
        return ResponseEntity.ok(discipline);
    }
}
