package com.example.mocks.application.usecases;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mocks.application.mappers.UserMapper;
import com.example.mocks.application.models.UserModel;
import com.example.mocks.infrastructure.repositories.UserRepository;

@Service
public final class GetterUserByIdUseCase {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public GetterUserByIdUseCase(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Optional<UserModel> execute(String id) {
        return this.userRepository.findById(id).map(user -> this.userMapper.toModel(user));
    }
}