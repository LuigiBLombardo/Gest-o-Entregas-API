package com.gestao.entregas.controller;

import com.gestao.entregas.dto.MotoristaRequestDTO;
import com.gestao.entregas.dto.MotoristaResponseDTO;
import com.gestao.entregas.entity.MotoristaEntity;
import com.gestao.entregas.service.MotoristaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controller REST responsável pelos endpoints relacionados ao recurso motoristas
 * */
@Tag(
        name = "Motorista",
        description = "Operações relacionadas ao gerenciamento de motoristas"
)
@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    private final MotoristaService service;

    public MotoristaController(MotoristaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MotoristaResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<MotoristaResponseDTO> cadastrar(@RequestBody @Valid MotoristaRequestDTO requestDTO){
        MotoristaResponseDTO responseDTO = service.cadastrar(requestDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDTO.id())
                .toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }
}
