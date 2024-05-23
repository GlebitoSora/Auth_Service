package com.example.auth_service.repository;

import com.example.auth_service.entity.ModularDiary;
import com.example.auth_service.entity.ModularDiaryPK;
import com.example.auth_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModularDiaryRepository extends JpaRepository<ModularDiary, ModularDiaryPK> {
    List<ModularDiary> findByStudent(Student student);
}
