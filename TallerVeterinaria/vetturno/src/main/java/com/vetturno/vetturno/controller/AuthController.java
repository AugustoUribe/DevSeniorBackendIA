package com.vetturno.vetturno.controller;

import com.vetturno.vetturno.dto.AuthResponse;
import com.vetturno.vetturno.dto.LoginRequest;
import com.vetturno.vetturno.dto.RegistroRequest;
import com.vetturno.vetturno.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registrar(
            @Valid @RequestBody RegistroRequest request) {

        return ResponseEntity.ok(
                authService.registrar(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }
}