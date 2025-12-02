package com.dieva.hexagonal.architecture.application.usecase.task.find;

import com.dieva.hexagonal.architecture.domain.error.TaskNotFoundException;
import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.domain.repository.port.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindTaskUseCase {

    private final TaskRepository taskRepository;

    public Task findById(TaskId id){
        return taskRepository.getById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public List<Task> findAll(){
        List<Task> taskLst = taskRepository.getAll();
        if (taskLst.isEmpty()){
            throw new TaskNotFoundException();
        }
        return taskLst;
    }
}
