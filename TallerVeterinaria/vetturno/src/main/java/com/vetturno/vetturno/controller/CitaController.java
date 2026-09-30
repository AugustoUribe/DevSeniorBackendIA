package com.vetturno.vetturno.controller;

import com.vetturno.vetturno.dto.CitaDTO;
import com.vetturno.vetturno.dto.CitaRequest;
import com.vetturno.vetturno.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public ResponseEntity<CitaDTO> crear(
            @Valid @RequestBody CitaRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(citaService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<CitaDTO>> listar() {

        return ResponseEntity.ok(
                citaService.listar()
        );
    }

    @GetMapping("/veterinario/{id}")
    public ResponseEntity<List<CitaDTO>> listarPorVeterinario(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                citaService.listarPorVeterinario(id)
        );
    }
}