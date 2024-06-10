package com.example.mocks.application.mappers;

import org.mapstruct.Mapper;

import com.example.mocks.application.models.FlowModel;
import com.example.mocks.domain.entities.Flow;

import java.util.List;

@Mapper(componentModel = "spring", uses = FlowMapper.class)
public interface FlowListMapper {

    List<Flow> toEntityList(List<FlowModel> models);
    List<FlowModel> toModelList(List<Flow> entities);
    
}
