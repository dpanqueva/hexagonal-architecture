package com.dieva.hexagonal.architecture.infrastructure.web.rest.user;

import com.dieva.hexagonal.architecture.application.usecase.user.edit.ChangePasswordUserUseCase;
import com.dieva.hexagonal.architecture.application.usecase.user.edit.EditUserUseCase;
import com.dieva.hexagonal.architecture.domain.model.User;
import com.dieva.hexagonal.architecture.infrastructure.mapper.user.UserCommandToUserRsMapper;
import com.dieva.hexagonal.architecture.infrastructure.mapper.user.UserEditRqCommandMapper;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.user.UserEditRequest;
import com.dieva.hexagonal.architecture.infrastructure.web.dto.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserPutController {

    private final EditUserUseCase editUserUseCase;
    private final UserEditRqCommandMapper userEditRqCommandMapper;
    private final UserCommandToUserRsMapper userCommandToUserRsMapper;
    private final ChangePasswordUserUseCase changePasswordUserUseCase;

    @PutMapping("auth/edit/{id}")
    public ResponseEntity<UserResponse> edit(@PathVariable UUID id, @RequestBody UserEditRequest user){
        User userEdited =  editUserUseCase.edit(id,userEditRqCommandMapper.toEntity(user));
        return ResponseEntity.ok(userCommandToUserRsMapper.toEntity(userEdited));
    }

    @PutMapping("auth/edit/{id}/password")
    public ResponseEntity<UserResponse> editPassword(@PathVariable UUID id, @RequestBody UserEditRequest user){
        User userEdited =  changePasswordUserUseCase.changePassword(id,user.password());
        return ResponseEntity.ok(userCommandToUserRsMapper.toEntity(userEdited));
    }
}
