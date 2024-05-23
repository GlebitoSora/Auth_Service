package com.example.auth_service.repository;

import com.example.auth_service.entity.Audience;
import com.example.auth_service.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByTutorId(Long id);
    List<Lesson> findByAudience(Audience audience);
    List<Lesson> findByGroup(String group);
}
