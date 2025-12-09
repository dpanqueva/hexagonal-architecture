package com.dieva.hexagonal.architecture.application.usecase.user.find;

import com.dieva.hexagonal.architecture.domain.error.UserNotFoundException;
import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.domain.model.UserId;
import com.dieva.hexagonal.architecture.domain.repository.port.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindUserUseCase {

    private final UserRepository userRepository;

    public User getById(UserId id){
        return userRepository.getById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAll(Iterable<UserId> ids){
        List<User> users = userRepository.getByIds(ids);
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return users;
    }
}
