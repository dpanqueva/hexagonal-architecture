package com.dieva.hexagonal.architecture.domain.model;

import lombok.Value;

@Value
public class TaskId {

    Long value;

    public static TaskId of(Long value) {
        return new TaskId(value);
    }
}
