package com.dieva.hexagonal.architecture.infrastructure.config;

import com.dieva.hexagonal.architecture.application.usecase.task.create.CreateTaskUseCase;
import com.dieva.hexagonal.architecture.application.usecase.task.edit.CompleteTaskUseCase;
import com.dieva.hexagonal.architecture.application.usecase.task.edit.EditTaskUseCase;
import com.dieva.hexagonal.architecture.application.usecase.task.find.FindTaskUseCase;
import com.dieva.hexagonal.architecture.domain.repository.port.TaskRepository;
import com.dieva.hexagonal.architecture.infrastructure.mapper.TaskMapper;
import com.dieva.hexagonal.architecture.infrastructure.repository.TaskEntityRepositoryJpa;
import com.dieva.hexagonal.architecture.infrastructure.repository.adapter.TaskRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TaskConfig {

    private final TaskEntityRepositoryJpa taskEntityRepositoryJpa;
    private final TaskMapper taskMapper;

    @Bean
    public TaskRepository taskRepository() {
        return new TaskRepositoryImpl(taskEntityRepositoryJpa, taskMapper);
    }

    @Bean
    public CreateTaskUseCase createTaskUseCase() {
        return new CreateTaskUseCase(taskRepository());
    }

    @Bean
    public FindTaskUseCase findTaskUseCase() {
        return new FindTaskUseCase(taskRepository());
    }

    @Bean
    public CompleteTaskUseCase completeTaskUseCase(){
        return new CompleteTaskUseCase(taskRepository());
    }

    @Bean
    public EditTaskUseCase editTaskUseCase(){
        return new EditTaskUseCase(taskRepository());
    }
}
