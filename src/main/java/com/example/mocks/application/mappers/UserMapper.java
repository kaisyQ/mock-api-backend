package com.example.mocks.application.mappers;

import org.mapstruct.Mapper;

import com.example.mocks.application.models.UserModel;
import com.example.mocks.domain.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEnity(UserModel model);
    UserModel toModel(User entity);
}