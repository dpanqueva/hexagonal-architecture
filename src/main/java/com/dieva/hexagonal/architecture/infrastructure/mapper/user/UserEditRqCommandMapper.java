package com.dieva.hexagonal.architecture.infrastructure.mapper.user;

import com.dieva.hexagonal.architecture.application.usecase.user.edit.EditUserCommand;
import com.dieva.hexagonal.architecture.infrastructure.mapper.GenericMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.user.UserEditRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEditRqCommandMapper extends GenericMapper<UserEditRequest, EditUserCommand> {

    @Override
    EditUserCommand toEntity(UserEditRequest dto);
}
