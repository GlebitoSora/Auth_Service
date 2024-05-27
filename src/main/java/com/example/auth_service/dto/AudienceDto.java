package com.example.auth_service.dto;

import com.example.auth_service.entity.Building;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Запрос с данными аудитории")
public class AudienceDto {
    private int audienceNumber;
    @Enumerated(EnumType.STRING)
    private Building building;
}
