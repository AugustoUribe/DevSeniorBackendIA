package com.vetturno.vetturno.service;

import com.vetturno.vetturno.dto.MascotaDTO;
import com.vetturno.vetturno.dto.MascotaRequest;
import com.vetturno.vetturno.model.Mascota;
import com.vetturno.vetturno.model.Propietario;
import com.vetturno.vetturno.repository.MascotaRepository;
import com.vetturno.vetturno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;

    public MascotaService(
            MascotaRepository mascotaRepository,
            PropietarioRepository propietarioRepository) {

        this.mascotaRepository = mascotaRepository;
        this.propietarioRepository = propietarioRepository;
    }

    public MascotaDTO crear(MascotaRequest request) {

        Propietario propietario = propietarioRepository
                .findById(request.getPropietarioId())
                .orElseThrow();

        Mascota mascota = new Mascota();

        mascota.setNombre(request.getNombre());
        mascota.setEspecie(request.getEspecie());
        mascota.setRaza(request.getRaza());
        mascota.setPropietario(propietario);

        Mascota guardada = mascotaRepository.save(mascota);

        return convertirADTO(guardada);
    }

    public List<MascotaDTO> listar() {
        return mascotaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private MascotaDTO convertirADTO(Mascota mascota) {
        return new MascotaDTO(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getEspecie(),
                mascota.getRaza(),
                mascota.getPropietario().getId(),
                mascota.getPropietario().getNombre()
        );
    }
}