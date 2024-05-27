package com.example.auth_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Запрос с данными преподавателя")
public class TutorDto {
    private String name;
    private String phoneNumber;
}
