package com.dieva.hexagonal.architecture.infrastructure.mapper.user;

import com.dieva.hexagonal.architecture.domain.model.TaskId;
import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.domain.model.UserId;
import com.dieva.hexagonal.architecture.infrastructure.mapper.GenericMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserCommandToUserRsMapper extends GenericMapper<User, UserResponse> {

    @Named("mapToId")
    default UUID mapToId(UserId userId) {
        return userId != null ? userId.getValue() : null;
    }

    @Named("mapFromId")
    default UserId mapFromId(UUID id) {
                return id != null ? UserId.of(id) : null;
           }
    @Override
    @Mapping(target = "id", source = "id", qualifiedByName = "mapToId")
    UserResponse toEntity(User dto);

    @Override
    @Mapping(target = "id", source = "id", qualifiedByName = "mapFromId")
    User toDto(UserResponse entity);
}
