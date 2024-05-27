package com.example.auth_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Запрос с данными пользоветеля")
public class UserDto {
    private String username;
    private String password;
}
