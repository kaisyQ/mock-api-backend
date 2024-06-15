package com.example.mocks.infrastructure.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mocks.domain.entities.User;
import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}