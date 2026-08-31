package com.DevSeniorAugusto.campusFlow.usuarios.controller;


import java.util.List;
import com.DevSeniorAugusto.campusFlow.usuarios.model.Usuario;
import com.DevSeniorAugusto.campusFlow.usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }
}