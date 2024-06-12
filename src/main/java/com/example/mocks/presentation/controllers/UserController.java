package com.example.mocks.presentation.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mocks.application.models.UserModel;
import com.example.mocks.application.usecases.GetterUserByIdUseCase;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/v1/users")
public final class UserController {
    
    private final GetterUserByIdUseCase getterUserByIdUseCase;

    public UserController(GetterUserByIdUseCase getterUserByIdUseCase) {
        this.getterUserByIdUseCase = getterUserByIdUseCase;
    }

    @GetMapping("/{id}")  
    public Optional<UserModel> getUser(@RequestParam String id) {
        return this.getterUserByIdUseCase.execute(id);
    }
}
