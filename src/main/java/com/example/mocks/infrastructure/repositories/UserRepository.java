package com.example.mocks.infrastructure.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mocks.domain.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

}