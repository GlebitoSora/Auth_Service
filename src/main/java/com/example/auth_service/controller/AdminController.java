package com.example.auth_service.controller;

import com.example.auth_service.dto.*;
import com.example.auth_service.entity.*;
import com.example.auth_service.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Tag(name = "Контроллер админа", description = "Возможность управления данными системы")
public class AdminController {
    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository;
    private final LessonRepository lessonRepository;
    private final AudienceRepository audienceRepository;
    private final DisciplineRepository disciplineRepository;
    @Operation(
            summary = "Добавление студента",
            description = "Позволяет добавить студента в базу данных"
    )
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
    @Operation(
            summary = "Добавление преподавателя",
            description = "Позволяет добавить преподавателя в базу данных"
    )
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
    @Operation(
            summary = "Добавление данных в расписание",
            description = "Позволяет редактировать данные расписания в бд"
    )
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
    @Operation(
            summary = "Добавление аудитории",
            description = "Позволяет добавить аудиторию в бдм"
    )
    @PostMapping("/add-audience")
    public ResponseEntity<?> addAudience(@RequestBody AudienceDto audienceDto){
        var audience = Audience.builder()
                .audienceNumber(audienceDto.getAudienceNumber())
                .building(audienceDto.getBuilding())
                .build();
        audienceRepository.save(audience);
        return ResponseEntity.ok(audience);
    }
    @Operation(
            summary = "Добавление дисциплины",
            description = "Позволяет добавить дисциплину в бд"
    )
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
