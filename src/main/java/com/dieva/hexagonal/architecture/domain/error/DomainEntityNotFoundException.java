package com.dieva.hexagonal.architecture.domain.error;

public class DomainEntityNotFoundException extends RuntimeException{

    public DomainEntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainEntityNotFoundException(String entity, String id){
        super("%s with id %s not found".formatted(entity, id));
    }

    public DomainEntityNotFoundException(String entity){
        super("%s not found".formatted(entity));
    }
}
