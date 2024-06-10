package com.example.mocks.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mocks.application.mappers.FlowListMapper;
import com.example.mocks.application.models.FlowModel;
import com.example.mocks.infrastructure.repositories.FlowRepository;

import java.util.List;

@Service
public class GetterFlowsUseCase {
    
    @Autowired
    private FlowRepository flowRepository;

    @Autowired
    private FlowListMapper flowListMapper;


    public List<FlowModel> execute() {
        
        var flows = this.flowRepository.findAll();

        return this.flowListMapper.toModelList(flows);
    }
}
