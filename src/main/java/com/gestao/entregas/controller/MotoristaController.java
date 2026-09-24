package com.gestao.entregas.controller;

import com.gestao.entregas.dto.MotoristaRequestDTO;
import com.gestao.entregas.dto.MotoristaResponseDTO;
import com.gestao.entregas.entity.MotoristaEntity;
import com.gestao.entregas.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    /**
     * Esse método é para buscar todos os motoristas do banco de dados
     *
     * @return List de motoristas.
     */
    @Operation(
            summary = "Buscar todos os motoristas",
            description = "Esse método vai ser excutado quando um ADMIN ou USER quiser buscar todos os motoristas."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Motorista listado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Algo deu errado ao listar os motoristas"
            )
    })
    @GetMapping
    public ResponseEntity<List<MotoristaResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    /**
     * Esse método é para cadastrar um motorista no banco de dados
     *
     * @param requestDTO resquest do motorista com os dados
     * @return response do motorista com os dados convertidos
     */
    @Operation(
            summary = "Cadastrar um Motorista",
            description = "Esse método vai ser excutado quando um ADMIN quiser cadastrar um motorista."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Motorista encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Algo deu errado ao cadastrar esse motorista"
            )
    })
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
