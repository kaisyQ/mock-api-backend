package com.example.mocks.application.usecases;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mocks.application.mappers.FlowMapper;
import com.example.mocks.application.models.FlowModel;
import com.example.mocks.infrastructure.repositories.FlowRepository;


@Service
public final class GetterFlowByIdUseCase {
    
    private final FlowRepository flowRepository;

    private final FlowMapper flowMapper;

    public GetterFlowByIdUseCase(FlowRepository flowRepository, FlowMapper flowMapper) {
        this.flowRepository = flowRepository;
        this.flowMapper = flowMapper;
    }

    public Optional<FlowModel> execute(String id) {
        
        return this.flowRepository.findById(id).map(flow -> flowMapper.toModel(flow));
        
    }
}
