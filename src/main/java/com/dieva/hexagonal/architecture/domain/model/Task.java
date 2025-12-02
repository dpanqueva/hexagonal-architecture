package com.dieva.hexagonal.architecture.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class Task {

    @Setter(AccessLevel.NONE)
    private TaskId taskId;

    private String title, description;

    private LocalDateTime createdAt;

    private boolean completed;

    public void taskCompleted() {
        this.completed = true;
    }

}
