package com.dieva.hexagonal.architecture.application.usecase.task.delete;

import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.domain.repository.port.TaskRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTaskUseCase {

    private final TaskRepository taskRepository;


    public void delete(Task task){
        deleteById(task.getTaskId());
    }

    public void deleteById(TaskId id){
        taskRepository.delete(id);
    }
}
