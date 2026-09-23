package com.gestao.entregas.controller;

import com.gestao.entregas.dto.MotoristaResponseDTO;
import com.gestao.entregas.service.MotoristaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
