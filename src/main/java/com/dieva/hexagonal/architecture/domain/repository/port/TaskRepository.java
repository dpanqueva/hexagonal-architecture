package com.dieva.hexagonal.architecture.domain.repository.port;

import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);

    List<Task> getAll();

    Optional<Task> getById(TaskId id);

    void delete(TaskId id);

}
