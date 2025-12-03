package com.dieva.hexagonal.architecture.application.usecase.task.edit;

import com.dieva.hexagonal.architecture.domain.model.TaskId;

public record EditTaskCommand(
        TaskId id,
        String title,
        String description,
        boolean completed
        ) {
}
