package com.example.mocks.presentation.controllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("docs")
@RestController
public class DocsController {
    
    @RequestMapping("")
    public void redirectToDocs(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}
