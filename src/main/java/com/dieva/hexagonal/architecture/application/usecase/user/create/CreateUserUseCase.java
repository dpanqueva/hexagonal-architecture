package com.dieva.hexagonal.architecture.application.usecase.user.create;

import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.domain.repository.port.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public User create(CreateUserCommand userCommand){
        User user = User.builder()
                .name(userCommand.name())
                .email(userCommand.email())
                .password(userCommand.password())
                .build();

        return userRepository.create(user);
    }
}
