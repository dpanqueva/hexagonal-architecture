package com.dieva.hexagonal.architecture.infrastructure.repository;

import com.dieva.hexagonal.architecture.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepositoryJpa extends JpaRepository<UserEntity, UUID> {
}
