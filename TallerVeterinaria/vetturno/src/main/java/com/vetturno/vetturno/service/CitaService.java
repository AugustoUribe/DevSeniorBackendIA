package com.vetturno.vetturno.service;

import com.vetturno.vetturno.dto.CitaDTO;
import com.vetturno.vetturno.dto.CitaRequest;
import com.vetturno.vetturno.model.Cita;
import com.vetturno.vetturno.model.Mascota;
import com.vetturno.vetturno.model.Veterinario;
import com.vetturno.vetturno.repository.CitaRepository;
import com.vetturno.vetturno.repository.MascotaRepository;
import com.vetturno.vetturno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public CitaService(
            CitaRepository citaRepository,
            MascotaRepository mascotaRepository,
            VeterinarioRepository veterinarioRepository) {

        this.citaRepository = citaRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    public CitaDTO crear(CitaRequest request) {

        Mascota mascota = mascotaRepository
                .findById(request.getMascotaId())
                .orElseThrow(() ->
                        new IllegalArgumentException("La mascota no existe"));

        Veterinario veterinario = veterinarioRepository
                .findById(request.getVeterinarioId())
                .orElseThrow(() ->
                        new IllegalArgumentException("El veterinario no existe"));

        if (request.getFechaHora().isBefore(LocalDateTime.now())
                || request.getFechaHora().isEqual(LocalDateTime.now())) {

            throw new IllegalArgumentException(
                    "La fecha de la cita debe ser futura");
        }

        boolean horarioOcupado =
                citaRepository.existsByVeterinarioIdAndFechaHora(
                        veterinario.getId(),
                        request.getFechaHora()
                );

        if (horarioOcupado) {
            throw new IllegalArgumentException(
                    "El veterinario ya tiene una cita en ese horario");
        }

        Cita cita = new Cita();

        cita.setFechaHora(request.getFechaHora());
        cita.setMotivo(request.getMotivo());
        cita.setMascota(mascota);
        cita.setVeterinario(veterinario);

        Cita guardada = citaRepository.save(cita);

        return convertirADTO(guardada);
    }

    public List<CitaDTO> listar() {
        return citaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<CitaDTO> listarPorVeterinario(Long veterinarioId) {
        return citaRepository.findByVeterinarioId(veterinarioId)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private CitaDTO convertirADTO(Cita cita) {

        return new CitaDTO(
                cita.getId(),
                cita.getFechaHora(),
                cita.getMotivo(),
                cita.getMascota().getNombre(),
                cita.getMascota().getPropietario().getNombre(),
                cita.getVeterinario().getNombre()
        );
    }
}