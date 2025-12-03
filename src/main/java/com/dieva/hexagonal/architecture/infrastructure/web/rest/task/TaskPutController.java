package com.dieva.hexagonal.architecture.infrastructure.web.rest.task;

import com.dieva.hexagonal.architecture.application.usecase.task.edit.CompleteTaskUseCase;
import com.dieva.hexagonal.architecture.application.usecase.task.edit.EditTaskUseCase;
import com.dieva.hexagonal.architecture.domain.model.Task;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.infrastructure.mapper.TaskCommandToTaskRsMapper;
import com.dieva.hexagonal.architecture.infrastructure.mapper.TaskRqEditToCommandMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.TaskEditRequest;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskPutController {

    private final EditTaskUseCase editTaskUseCase;
    private final CompleteTaskUseCase completeTaskUseCase;
    private final TaskCommandToTaskRsMapper taskCommandToTaskRsMapper;
    private final TaskRqEditToCommandMapper taskRqEditToCommandMapper;

    @PutMapping("/{id}/complete")
    public TaskResponse completeTask(@PathVariable Long id){
        Task task = completeTaskUseCase.completeTask(TaskId.of(id));
        return taskCommandToTaskRsMapper.toEntity(task);
    }

    @PutMapping("/{id}")
    public TaskResponse editTask(@PathVariable Long id, @RequestBody TaskEditRequest taskEditRequest){
        Task task = editTaskUseCase.update(id,taskRqEditToCommandMapper.toEntity(taskEditRequest));
        return taskCommandToTaskRsMapper.toEntity(task);
    }
}
