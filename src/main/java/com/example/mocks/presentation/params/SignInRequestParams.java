package com.example.mocks.presentation.params;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// @Setter
// @Getter
// @AllArgsConstructor
public class SignInRequestParams {
    private String email;
    private String password;

    public SignInRequestParams(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}