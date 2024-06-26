package com.example.mocks.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document(collection = "flows")
public class Flow {
    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String alias;
}
