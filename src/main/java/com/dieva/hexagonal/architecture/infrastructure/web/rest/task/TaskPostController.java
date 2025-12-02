package com.dieva.hexagonal.architecture.infrastructure.web.rest.task;

import com.dieva.hexagonal.architecture.application.usecase.task.create.CreateTaskCommand;
import com.dieva.hexagonal.architecture.application.usecase.task.create.CreateTaskUseCase;
import com.dieva.hexagonal.architecture.infrastructure.mapper.TaskCommandToTaskRsMapper;
import com.dieva.hexagonal.architecture.infrastructure.mapper.TaskRqToCommandMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.TaskRequest;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskPostController {

    private final CreateTaskUseCase createTaskUseCase;
    private final TaskRqToCommandMapper taskRqToCommandMapper;
    private final TaskCommandToTaskRsMapper taskCommandToTaskRsMapper;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest) {

        CreateTaskCommand createTaskCommand = taskRqToCommandMapper.toEntity(taskRequest);

        return ResponseEntity.created(URI.create("/tasks"))
                .body(taskCommandToTaskRsMapper.toEntity(createTaskUseCase.create(createTaskCommand)));

    }
}
