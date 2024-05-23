package com.example.auth_service.dto;

import com.example.auth_service.entity.Audience;
import com.example.auth_service.entity.Discipline;
import com.example.auth_service.entity.Tutor;
import com.example.auth_service.entity.TypeOfLesson;
import com.example.auth_service.repository.AudienceRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonDto {
    private String group;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private String description;
    @Enumerated(EnumType.STRING)
    private TypeOfLesson typeOfLesson;
    private String tutorName;
    private String disciplineName;
    private int audienceNumber;
}
