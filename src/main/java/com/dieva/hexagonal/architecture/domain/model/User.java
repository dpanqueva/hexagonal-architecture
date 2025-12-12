package com.dieva.hexagonal.architecture.domain.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class User {

    @Setter(AccessLevel.NONE)
    private UserId id;
    private String name;
    private String email;
    private String password;

    @Builder.Default
    private String role = "USER";
}
