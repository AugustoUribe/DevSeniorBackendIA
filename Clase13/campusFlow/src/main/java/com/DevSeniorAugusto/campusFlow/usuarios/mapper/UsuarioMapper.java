package com.DevSeniorAugusto.campusFlow.usuarios.mapper;

import com.DevSeniorAugusto.campusFlow.usuarios.dto.UsuarioResponse;
import com.DevSeniorAugusto.campusFlow.usuarios.model.Usuario;
import com.DevSeniorAugusto.campusFlow.usuarios.model.PreferenciasUsuario;

public class UsuarioMapper {

    public static UsuarioResponse toResponse(Usuario usuario) {
        PreferenciasUsuario preferencias = usuario.getPreferencias();
        if (preferencias == null) {
            preferencias = new PreferenciasUsuario();
        }
        UsuarioResponse response = new UsuarioResponse();
        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setEmail(usuario.getEmail());
        response.setRol(usuario.getRol());
        response.setTema(preferencias.getTema());
        response.setNotificacionesActivas(preferencias.isNotificacionesActivas());
        return response;
    }
}