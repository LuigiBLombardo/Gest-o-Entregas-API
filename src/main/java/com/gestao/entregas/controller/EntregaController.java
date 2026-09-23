package com.gestao.entregas.controller;

import com.gestao.entregas.dto.EntregaResponseDTO;
import com.gestao.entregas.dto.MotoristaResponseDTO;
import com.gestao.entregas.service.EntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    private final EntregaService service;

    public EntregaController (EntregaService service){

        this.service = service;
    }

    @GetMapping("/api/entregas/{id}")
    public ResponseEntity<EntregaResponseDTO> buscarporID(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorID(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
