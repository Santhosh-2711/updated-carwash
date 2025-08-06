package com.example.carwash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carwash.service.JwtService;

@RestController
@RequestMapping("/internal")
public class TokenController {

    private final JwtService jwtService;

    public TokenController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/token")
    public String getInternalToken() {
        return jwtService.generateInternalServiceToken();
    }
}

