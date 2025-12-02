package com.dieva.hexagonal.architecture.infrastructure.web.rest.task;

import com.dieva.hexagonal.architecture.application.usecase.task.find.FindTaskUseCase;
import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.infrastructure.mapper.TaskCommandToTaskRsMapper;
import com.dieva.hexagonal.architecture.infrastructure.mapper.TaskMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskGetController {

    private final FindTaskUseCase findTaskUseCase;
    private final TaskCommandToTaskRsMapper taskCommandToTaskRsMapper;



    @GetMapping
    public List<TaskResponse> allTask() {
        return findTaskUseCase.findAll()
                .stream()
                .map(list ->taskCommandToTaskRsMapper.toEntity(list))
                .toList();
    }

    @GetMapping("/{id}")
    public TaskResponse taskById(@PathVariable Long id){
        Task task = findTaskUseCase.findById(TaskId.of(id));
        return taskCommandToTaskRsMapper.toEntity(task);
    }
}
