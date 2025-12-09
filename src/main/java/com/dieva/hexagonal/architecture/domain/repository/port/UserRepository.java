package com.dieva.hexagonal.architecture.domain.repository.port;

import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.domain.model.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User create(User user);
    User update(User user);

    Optional<User> changePassword(UserId id, String newPassword);
    Optional<User> getById(UserId id);
    Optional<User> getByEmail(String email);
    List<User> getByIds(Iterable<UserId> ids);
}
