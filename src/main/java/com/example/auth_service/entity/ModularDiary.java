package com.example.auth_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "modular_diary")
public class ModularDiary {
    @EmbeddedId
    private ModularDiaryPK modularDiaryPK;
    @Column(name = "first_module")
    private int firstModule;
    @Column(name = "second_module")
    private int secondModule;
    @Column(name = "exam")
    private int exam;
    @ManyToOne
    @JoinColumn(name = "student", insertable = false, updatable = false)
    private Student student;

    // Связь с дисциплиной
    @ManyToOne
    @JoinColumn(name = "discipline", insertable = false, updatable = false)
    private Discipline discipline;
}
