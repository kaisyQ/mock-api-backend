package com.example.mocks.application.usecases;

import org.springframework.stereotype.Service;

import com.example.mocks.application.mappers.FlowListMapper;
import com.example.mocks.application.models.FlowModel;
import com.example.mocks.infrastructure.repositories.FlowRepository;

import java.util.List;

@Service
public final class GetterFlowsUseCase {
    
    private FlowRepository flowRepository;
    private FlowListMapper flowListMapper;

    public GetterFlowsUseCase(FlowRepository flowRepository, FlowListMapper flowListMapper) {
        this.flowListMapper = flowListMapper;
        this.flowRepository = flowRepository;
    }


    public List<FlowModel> execute() {
        
        var flows = this.flowRepository.findAll();

        return this.flowListMapper.toModelList(flows);
    }
}
