package com.vetturno.vetturno.controller;

import com.vetturno.vetturno.dto.PropietarioDTO;
import com.vetturno.vetturno.dto.PropietarioRequest;
import com.vetturno.vetturno.service.PropietarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping
    public ResponseEntity<PropietarioDTO> crear(
            @Valid @RequestBody PropietarioRequest request) {

        PropietarioDTO propietario = propietarioService.crear(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(propietario);
    }

    @GetMapping
    public ResponseEntity<List<PropietarioDTO>> listar() {

        return ResponseEntity.ok(propietarioService.listar());
    }
}