package com.dieva.hexagonal.architecture.infrastructure.web.dto.user;

import java.util.UUID;

public record UserResponse(UUID id, String name, String email, String role) {
}
