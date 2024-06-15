package com.example.mocks.application.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.mocks.infrastructure.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        var optionalUser = this.userRepository.findByEmail(email);

        var userDetails = User.builder();

        if (optionalUser.isPresent()) {
                    
            var roles = new ArrayList<String>();
            roles.add("USER");  

            var user = optionalUser.get();
            
            userDetails
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(roles.toArray(new String[0]))
            ;
        }

        return userDetails.build();

    }

    
}
