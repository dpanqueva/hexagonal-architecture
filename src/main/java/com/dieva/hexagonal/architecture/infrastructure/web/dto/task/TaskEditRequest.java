package com.dieva.hexagonal.architecture.infrastructure.web.dto.task;

public record TaskEditRequest(String title,String description, boolean completed) {
}
