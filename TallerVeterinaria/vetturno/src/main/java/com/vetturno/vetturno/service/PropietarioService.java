package com.vetturno.vetturno.service;


import com.vetturno.vetturno.dto.PropietarioDTO;
import com.vetturno.vetturno.dto.PropietarioRequest;
import com.vetturno.vetturno.model.Propietario;
import com.vetturno.vetturno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public PropietarioDTO crear(PropietarioRequest request) {

        Propietario propietario = new Propietario();

        propietario.setNombre(request.getNombre());
        propietario.setTelefono(request.getTelefono());
        propietario.setEmail(request.getEmail());

        Propietario guardado = propietarioRepository.save(propietario);

        return convertirADTO(guardado);
    }

    public List<PropietarioDTO> listar() {
        return propietarioRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private PropietarioDTO convertirADTO(Propietario propietario) {
        return new PropietarioDTO(
                propietario.getId(),
                propietario.getNombre(),
                propietario.getTelefono(),
                propietario.getEmail()
        );
    }
}