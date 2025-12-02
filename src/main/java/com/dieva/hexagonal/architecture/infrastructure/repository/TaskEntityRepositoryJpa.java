package com.dieva.hexagonal.architecture.infrastructure.repository;

import com.dieva.hexagonal.architecture.infrastructure.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskEntityRepositoryJpa extends JpaRepository<TaskEntity, Long> {
}
