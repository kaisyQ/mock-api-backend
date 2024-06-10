package com.example.mocks.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "flows")
public class Flow {
    @Id
    private String id;

    private String name;
}
