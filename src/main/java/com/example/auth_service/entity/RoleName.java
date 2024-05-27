package com.example.auth_service.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Роли")
public enum RoleName {
    ROLE_USER,
    ROLE_ADMIN
}
