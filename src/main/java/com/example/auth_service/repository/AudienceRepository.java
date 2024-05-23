package com.example.auth_service.repository;

import com.example.auth_service.entity.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AudienceRepository extends JpaRepository<Audience, Long> {
    Audience findByAudienceNumber(long number);

}
