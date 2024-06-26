package com.example.mocks.application.models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FlowModel {
    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String alias;
}
