package com.dieva.hexagonal.architecture.infrastructure.web.rest.user;

import com.dieva.hexagonal.architecture.application.usecase.user.create.CreateUserUseCase;
import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.infrastructure.mapper.user.UserCommandToUserRsMapper;
import com.dieva.hexagonal.architecture.infrastructure.mapper.user.UserRqToCommandMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.user.UserRequest;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserPostController {

    private  final CreateUserUseCase createUserUseCase;
    private final UserRqToCommandMapper userRqToCommandMapper;
    private final UserCommandToUserRsMapper userCommandToUserRsMapper;
    @PostMapping("/auth/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        User user = createUserUseCase.create(userRqToCommandMapper.toEntity(userRequest));
        return ResponseEntity.created(URI.create("/auth/register"))
                .body(userCommandToUserRsMapper.toEntity(user));
    }

}
