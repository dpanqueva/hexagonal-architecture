package com.dieva.hexagonal.architecture.application.usecase.task.edit;

import com.dieva.hexagonal.architecture.domain.error.TaskNotFoundException;
import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.domain.repository.port.TaskRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompleteTaskUseCase {

    private final TaskRepository taskRepository;

    public Task completeTask(Task task){
        task.taskCompleted();
        return taskRepository.save(task);
    }

    public Task completeTask(TaskId id){
        return taskRepository.getById(id)
                .map(t-> {
                    t.taskCompleted();
                    return taskRepository.save(t);
                })
                .orElseThrow(() -> new TaskNotFoundException(id));

    }
}
