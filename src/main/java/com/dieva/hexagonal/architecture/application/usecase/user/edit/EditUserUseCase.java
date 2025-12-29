package com.dieva.hexagonal.architecture.application.usecase.user.edit;

import com.dieva.hexagonal.architecture.application.usecase.task.edit.EditTaskCommand;
import com.dieva.hexagonal.architecture.domain.error.UserNotFoundException;
import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.domain.model.UserId;
import com.dieva.hexagonal.architecture.domain.repository.port.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class EditUserUseCase {

    private final UserRepository userRepository;

    public User edit(UUID id, EditUserCommand command){
        return userRepository.getById(UserId.of(id))
                .map(user ->{
                    user.setName(command.name());
                    user.setEmail(command.email());
                    return userRepository.update(user);
                }).orElseThrow(()-> new UserNotFoundException(UserId.of(id)));

    }
}

