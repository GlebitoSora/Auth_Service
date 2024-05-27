package com.example.auth_service.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Тип занятия")
public enum TypeOfLesson {
    SEMINAR,
    LECTURE,
    LABORATORY
}
