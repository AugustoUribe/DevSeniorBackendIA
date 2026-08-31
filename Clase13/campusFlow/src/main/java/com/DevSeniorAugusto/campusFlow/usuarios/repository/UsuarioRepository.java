package com.DevSeniorAugusto.campusFlow.usuarios.repository;

import com.DevSeniorAugusto.campusFlow.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}