package com.dieva.hexagonal.architecture.application.usecase.user.edit;

public record EditUserCommand(String name, String email, String password) {
}
