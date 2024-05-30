package com.example.auth_service.controller;

import com.example.auth_service.entity.Lesson;
import com.example.auth_service.entity.ModularDiary;
import com.example.auth_service.entity.Student;
import com.example.auth_service.entity.Tutor;
import com.example.auth_service.repository.LessonRepository;
import com.example.auth_service.repository.ModularDiaryRepository;
import com.example.auth_service.repository.StudentRepository;
import com.example.auth_service.repository.TutorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
@Tag(name = "Контррллер студентов", description = "Позволяет студентам взаимодействовать с системой")
public class StudentController {
    private final TutorRepository tutorRepository;
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;
    private final ModularDiaryRepository modularDiaryRepository;
    @Operation(
            summary = "Получение распписания по группе",
            description = "Позволяет получить данные расписания студентов по группе"
    )
    @GetMapping("/get-lessons/{group}")
    public List<Lesson> getLessons(@PathVariable String group){
        return lessonRepository.findByGroup(group);
    }
    @Operation(
            summary = "Получение расписания преподавателей",
            description = "Позволяет получить студентам расписание преподавателей"
    )
    @GetMapping("/get-tutor-lessons/{name}")
    public List<Lesson> getTutorLessons(@PathVariable String name){
        Tutor tutor = tutorRepository.findByName(name);
        return lessonRepository.findByTutorId(tutor.getId());
    }
    @Operation(
            summary = "Получение информации модульного журнала",
            description = "Позволяет студентам получить информацию об оценках в модульном журнале"
    )
    @GetMapping("/get-modular-diary/{name}")
    public List<ModularDiary> getModularDiary(@PathVariable String name){
        Student student = studentRepository.findByName(name);
        return modularDiaryRepository.findByStudent(student);
    }
    @GetMapping("/get-group/{name}")
    public String getGroup(@PathVariable String name){
        Student student = studentRepository.findByName(name);
        return student.getGroup();
    }
}
