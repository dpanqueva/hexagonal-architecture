package com.dieva.hexagonal.architecture.domain.error;

import com.dieva.hexagonal.architecture.domain.model.TaskId;

public class TaskNotFoundException extends DomainEntityNotFoundException
{
    public TaskNotFoundException() {
        super("task");
    }

    public TaskNotFoundException(TaskId id) {
        super("task", id.getValue().toString());
    }
}
