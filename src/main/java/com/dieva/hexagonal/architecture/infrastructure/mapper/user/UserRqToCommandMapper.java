package com.dieva.hexagonal.architecture.infrastructure.mapper.user;

import com.dieva.hexagonal.architecture.application.usecase.user.create.CreateUserCommand;
import com.dieva.hexagonal.architecture.infrastructure.mapper.GenericMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.user.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRqToCommandMapper extends GenericMapper<UserRequest, CreateUserCommand> {

    @Override
    CreateUserCommand toEntity(UserRequest dto);
}
