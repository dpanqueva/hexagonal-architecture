package com.dieva.hexagonal.architecture.infrastructure.config;

import com.dieva.hexagonal.architecture.application.usecase.user.create.CreateUserUseCase;
import com.dieva.hexagonal.architecture.application.usecase.user.find.FindUserUseCase;
import com.dieva.hexagonal.architecture.domain.repository.port.UserRepository;
import com.dieva.hexagonal.architecture.infrastructure.mapper.user.UserMapper;
import com.dieva.hexagonal.architecture.infrastructure.repository.UserEntityRepositoryJpa;
import com.dieva.hexagonal.architecture.infrastructure.repository.adapter.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class UserConfig {

    private final UserEntityRepositoryJpa userEntityRepositoryJpa;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Bean
    public UserRepository userRepositoryJpa(){
        return new UserRepositoryImpl(userEntityRepositoryJpa, passwordEncoder, userMapper);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(){
        return new CreateUserUseCase(userRepositoryJpa());
    }

    @Bean
    public FindUserUseCase findUserUseCase(){
        return new FindUserUseCase(userRepositoryJpa());
    }
}
