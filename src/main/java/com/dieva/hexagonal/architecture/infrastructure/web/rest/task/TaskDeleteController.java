package com.dieva.hexagonal.architecture.infrastructure.web.rest.task;

import com.dieva.hexagonal.architecture.application.usecase.task.delete.DeleteTaskUseCase;
import com.dieva.hexagonal.architecture.domain.model.TaskId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskDeleteController {

    private final DeleteTaskUseCase deleteTaskUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        deleteTaskUseCase.deleteById(TaskId.of(id));
        return ResponseEntity.noContent().build();
    }
}
