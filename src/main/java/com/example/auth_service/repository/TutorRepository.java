package com.example.auth_service.repository;

import com.example.auth_service.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Tutor findByName(String name);
    boolean existsByPhoneNumber(String phoneNumber);
}
