package com.dieva.hexagonal.architecture.domain.error;

import com.dieva.hexagonal.architecture.domain.model.UserId;

public class UserNotFoundException extends DomainEntityNotFoundException {
    public UserNotFoundException() {
        super("USER");
    }

    public UserNotFoundException(UserId id){
        super("USER", id.getValue().toString());
    }
}
