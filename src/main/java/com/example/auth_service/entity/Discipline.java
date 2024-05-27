package com.example.auth_service.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "discipline")
@Schema(name = "Дисциплина")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discipline_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "department")
    private String department;
}
