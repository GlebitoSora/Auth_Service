package com.example.auth_service.controller;

import com.example.auth_service.dto.ModularDiaryDto;
import com.example.auth_service.entity.*;
import com.example.auth_service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tutor")
public class TutorController {
    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository;
    private final LessonRepository lessonRepository;
    private final AudienceRepository audienceRepository;
    private final ModularDiaryRepository modularDiaryRepository;
    private final DisciplineRepository disciplineRepository;
    @GetMapping("/get-students/{group}")
    public List<Student> getAllStudent(@PathVariable String group) {
        try{
            return studentRepository.findByGroup(group);
        } catch (Exception e){
            return null;
        }
    }
    @GetMapping("/get-lessons/{name}")
    public List<Lesson> getLessonsByTutor(@PathVariable String name){
        Tutor tutor = tutorRepository.findByName(name);
        return lessonRepository.findByTutorId(tutor.getId());
    }
    @GetMapping("/get-audience/{audienceNumber}")
    public List<Lesson> getLessonsByAudience(@PathVariable long audienceNumber){
        Audience audience = audienceRepository.findByAudienceNumber(audienceNumber);
        return lessonRepository.findByAudience(audience);
    }
    @PostMapping("/set-rating")
    public ModularDiary setRating(@RequestBody ModularDiaryDto modularDiaryDto){
        var modularDiary = ModularDiary.builder()
                .modularDiaryPK(ModularDiaryPK.builder()
                        .student(studentRepository.findByNameAndGroup(modularDiaryDto.getStudentName(), modularDiaryDto.getGroup()).getId())
                        .discipline(disciplineRepository.findByName(modularDiaryDto.getDisciplineName()).getId())
                        .build())
                .firstModule(modularDiaryDto.getFirstModule())
                .secondModule(modularDiaryDto.getSecondModule())
                .exam(modularDiaryDto.getExam())
                .student(studentRepository.findByNameAndGroup(modularDiaryDto.getStudentName(), modularDiaryDto.getGroup()))
                .discipline(disciplineRepository.findByName(modularDiaryDto.getDisciplineName()))
                .build();
        modularDiaryRepository.save(modularDiary);
        return modularDiary;
    }
}