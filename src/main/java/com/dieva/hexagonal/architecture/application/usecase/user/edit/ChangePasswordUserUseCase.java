package com.dieva.hexagonal.architecture.application.usecase.user.edit;

import com.dieva.hexagonal.architecture.domain.error.UserNotFoundException;
import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.domain.model.UserId;
import com.dieva.hexagonal.architecture.domain.repository.port.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ChangePasswordUserUseCase {

    private final UserRepository userRepository;

    public User changePassword(UUID id, String password){
        final var userId = UserId.of(id);
        return userRepository.changePassword(userId, password)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}
