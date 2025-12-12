package com.dieva.hexagonal.architecture.infrastructure.mapper.user;

import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.domain.model.UserId;
import com.dieva.hexagonal.architecture.infrastructure.entity.UserEntity;
import com.dieva.hexagonal.architecture.infrastructure.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserEntity> {

    @Named("mapToId")
    default UUID mapToId(UserId userId) {
        return userId != null ? userId.getValue() : null;
    }

    @Named("mapToUserId")
    default UserId mapToUserId(UUID id) {
        return id != null ? UserId.of(id) : null;
    }
    @Override
    @Mapping(target = "id", source = "id", qualifiedByName = "mapToId")
    UserEntity toEntity(User dto);

    @Override
    @Mapping(target = "id", source = "id", qualifiedByName = "mapToUserId")
    User toDto(UserEntity entity);
}
