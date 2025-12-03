package com.dieva.hexagonal.architecture.application.usecase.task.edit;


import com.dieva.hexagonal.architecture.domain.error.TaskNotFoundException;
import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.domain.repository.port.TaskRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditTaskUseCase {

    private final TaskRepository taskRepository;

    public Task update(Long id,EditTaskCommand command){
        return taskRepository.getById(TaskId.of(id))
                .map(t -> {
                    t.setTitle(command.title());
                    t.setDescription(command.description());
                    t.setCompleted(command.completed());
                    return taskRepository.save(t);
                }).orElseThrow(()-> new TaskNotFoundException(command.id()));
    }
}
