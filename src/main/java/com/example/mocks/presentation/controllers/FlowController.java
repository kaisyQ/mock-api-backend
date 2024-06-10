package com.example.mocks.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mocks.application.models.FlowModel;
import com.example.mocks.application.usecases.GetterFlowsUseCase;
import com.example.mocks.domain.entities.Flow;
import com.example.mocks.infrastructure.repositories.FlowRepository;
import com.example.mocks.presentation.params.CreateFlowParams;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/flows")
public class FlowController {
    

    @Autowired
    private GetterFlowsUseCase getterFlowsUseCase;

    @Autowired
    private FlowRepository flowRepository;


    @GetMapping("")
    public List<FlowModel> getAll() {
        return this.getterFlowsUseCase.execute();
    }

    @PostMapping("")
    public void create(@RequestBody CreateFlowParams params) {

        var flow = new Flow();

        flow.setName(params.getName());

        this.flowRepository.save(flow);
    }
}
