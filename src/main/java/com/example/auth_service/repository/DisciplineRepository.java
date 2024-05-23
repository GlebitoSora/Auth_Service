package com.example.auth_service.repository;

import com.example.auth_service.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    Discipline findByName(String name);
}
