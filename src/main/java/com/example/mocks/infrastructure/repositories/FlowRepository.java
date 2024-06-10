package com.example.mocks.infrastructure.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mocks.domain.entities.Flow;

public interface FlowRepository extends MongoRepository<Flow, String> {

    
}