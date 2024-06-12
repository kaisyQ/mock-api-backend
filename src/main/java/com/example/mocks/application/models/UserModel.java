package com.example.mocks.application.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserModel {
    @NotNull
    private String id;

    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;
}
