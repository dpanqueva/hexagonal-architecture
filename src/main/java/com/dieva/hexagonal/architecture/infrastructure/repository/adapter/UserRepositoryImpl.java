package com.dieva.hexagonal.architecture.infrastructure.repository.adapter;

import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.domain.model.UserId;
import com.dieva.hexagonal.architecture.domain.repository.port.UserRepository;
import com.dieva.hexagonal.architecture.infrastructure.entity.UserEntity;
import com.dieva.hexagonal.architecture.infrastructure.mapper.UserMapper;
import com.dieva.hexagonal.architecture.infrastructure.repository.UserEntityRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserEntityRepositoryJpa userEntityRepositoryJpa;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    @Override
    public User create(User user) {
        UserEntity entity = userMapper.toEntity(user);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userMapper.toDto(userEntityRepositoryJpa.save(entity));
    }

    @Override
    public User update(User user) {
        UserEntity entity = userMapper.toEntity(user);
        return userMapper.toDto(userEntityRepositoryJpa.save(entity));
    }

    @Override
    public Optional<User> changePassword(UserId id, String newPassword) {

        return userEntityRepositoryJpa.findById(id.getValue())
                .map(entity -> {
                    entity.setPassword(passwordEncoder.encode(newPassword));
                    return userMapper.toDto(userEntityRepositoryJpa.save(entity));
                });
    }

    @Override
    public Optional<User> getById(UserId id) {
        return userEntityRepositoryJpa.findById(id.getValue())
                .map(userMapper::toDto);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userEntityRepositoryJpa.findByEmail(email)
                .map(userMapper::toDto);
    }

    @Override
    public List<User> getByIds(Iterable<UserId> ids) {
        List<UUID> uuids = StreamSupport.stream(ids.spliterator(), false)
                .map(UserId::getValue)
                .toList();
        return userEntityRepositoryJpa.findAllById(uuids)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}
