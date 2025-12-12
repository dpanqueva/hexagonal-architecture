package com.dieva.hexagonal.architecture.application.usecase.user.create;

public record CreateUserCommand(String name, String email, String password) {
}
