package com.dieva.hexagonal.architecture.infrastructure.entity;

public enum UserRole {
    ADMIN,
    USER;

    public static UserRole of(String role){
     try{
         return UserRole.valueOf(role);
     } catch (IllegalArgumentException e) {
         return USER;
     }
    }
}
