package com.dieva.hexagonal.architecture.infrastructure.security.model;

import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.domain.model.UserId;
import com.dieva.hexagonal.architecture.infrastructure.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class AuthUser implements UserDetails {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.toString()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    public UserId getIdAsUserId(){
        return UserId.of(id);
    }

    public static AuthUser of(User user){
        return AuthUser.builder()
                .id(user.getId().getValue())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(UserRole.of(user.getRole()))
                .build();
    }
}
