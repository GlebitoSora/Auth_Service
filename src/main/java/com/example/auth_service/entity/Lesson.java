package com.example.auth_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "group_of_students")
    private String group;
    @Column(name = "time")
    private LocalDateTime dateTime;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeOfLesson typeOfLesson;
    @ManyToOne
    @JoinColumn(name = "tutor_id", insertable = false, updatable = false)
    private Tutor tutor;
    @ManyToOne
    @JoinColumn(name = "discipline_id", insertable = false, updatable = false)
    private Discipline discipline;
    @ManyToOne
    @JoinColumn(name = "audience_id", insertable = false, updatable = false)
    private Audience audience;

}
