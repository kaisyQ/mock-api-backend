package com.example.mocks.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mocks.domain.entities.User;
import com.example.mocks.domain.security.JwtUtils;
import com.example.mocks.presentation.params.SignInRequestParams;
import com.example.mocks.presentation.params.SignInResponseParams;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    @ResponseBody
    @PostMapping("sign-in")
    public ResponseEntity<SignInResponseParams> login(@RequestBody SignInRequestParams request)  {

            var authentication =
                    authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            
            var email = authentication.getName();
            
            var user = new User();
            user.setEmail(email);
            var token = this.jwtUtils.createToken(user);
            var response = new SignInResponseParams(email, token);

            return ResponseEntity.ok(response);
    }

}
