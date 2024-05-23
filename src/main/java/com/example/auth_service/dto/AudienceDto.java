package com.example.auth_service.dto;

import com.example.auth_service.entity.Building;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AudienceDto {
    private int audienceNumber;
    @Enumerated(EnumType.STRING)
    private Building building;
}
