package com.JavaClasesSabados.gestor_productos.controller;

import com.JavaClasesSabados.gestor_productos.dto.AuthResponse;
import com.JavaClasesSabados.gestor_productos.dto.LoginRequest;
import com.JavaClasesSabados.gestor_productos.dto.RegistroRequest;
import com.JavaClasesSabados.gestor_productos.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.JavaClasesSabados.gestor_productos.dto.*;
import com.JavaClasesSabados.gestor_productos.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService s){ this.authService = s; }

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegistroRequest req){
        return authService.registrar(req);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req){
        return authService.login(req);
    }
}



/*
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegistroRequest request) {
        return authService.registrar(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}*/