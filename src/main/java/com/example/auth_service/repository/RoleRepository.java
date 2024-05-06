package com.example.auth_service.repository;

import com.example.auth_service.entity.Role;
import com.example.auth_service.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(RoleName role);
}
