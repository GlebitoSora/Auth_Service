package com.example.auth_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleName role;
}
