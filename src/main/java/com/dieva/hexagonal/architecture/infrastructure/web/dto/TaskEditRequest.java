package com.dieva.hexagonal.architecture.infrastructure.web.dto;

public record TaskEditRequest(String title,String description, boolean completed) {
}
