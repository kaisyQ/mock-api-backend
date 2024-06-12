package com.example.mocks.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document(collection = "users")
public class User {

    @Id
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
