package com.vetturno.vetturno.service;

import com.vetturno.vetturno.dto.AuthResponse;
import com.vetturno.vetturno.dto.LoginRequest;
import com.vetturno.vetturno.dto.RegistroRequest;
import com.vetturno.vetturno.model.Rol;
import com.vetturno.vetturno.model.Usuario;
import com.vetturno.vetturno.repository.UsuarioRepository;
import com.vetturno.vetturno.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse registrar(RegistroRequest request) {

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException(
                    "El email ya se encuentra registrado");
        }

        Usuario usuario = new Usuario();

        usuario.setEmail(request.getEmail());
        usuario.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        usuario.setRol(Rol.USER);

        usuarioRepository.save(usuario);

        String token =
                jwtService.generarToken(usuario.getEmail());

        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token =
                jwtService.generarToken(request.getEmail());

        return new AuthResponse(token);
    }
}