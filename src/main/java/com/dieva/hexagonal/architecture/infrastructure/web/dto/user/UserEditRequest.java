package com.dieva.hexagonal.architecture.infrastructure.web.dto.user;

public record UserEditRequest(String name, String email, String password) {
}
