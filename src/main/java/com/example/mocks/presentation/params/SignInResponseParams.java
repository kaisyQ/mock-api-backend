package com.example.mocks.presentation.params;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SignInResponseParams {
    private final String email;
    private final String token;
}
