package com.example.auth_service.repository;

import com.example.auth_service.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
}
