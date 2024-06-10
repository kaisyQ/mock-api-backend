package com.example.mocks.application.mappers;

import org.mapstruct.Mapper;

import com.example.mocks.application.models.FlowModel;
import com.example.mocks.domain.entities.Flow;

@Mapper(componentModel = "spring")
public interface FlowMapper {
    Flow toEntity(FlowModel model);
    FlowModel toModel(Flow entity);
}
