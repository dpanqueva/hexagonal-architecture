package com.dieva.hexagonal.architecture.application.usecase.task.create;

import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.repository.port.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CreateTaskUseCase {

    private final TaskRepository taskRepository;

    public Task create(CreateTaskCommand command){
        Task task = Task.builder()
                .title(command.title())
                .description(command.title())
                .createdAt(LocalDateTime.now())
                .completed(false)
                .build();

        return taskRepository.save(task);

    }
}
