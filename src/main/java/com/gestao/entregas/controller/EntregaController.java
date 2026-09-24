package com.gestao.entregas.controller;

import com.gestao.entregas.dto.EntregaResponseDTO;
import com.gestao.entregas.dto.MotoristaResponseDTO;
import com.gestao.entregas.service.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    private final EntregaService service;

    public EntregaController (EntregaService service){

        this.service = service;
    }

    /**
     * Esse método é para buscar uma entrega no banco de dados atráves do id solicitado
     *
     * @param id id da entrega que será buscada no banco.
     * @return List de entrega com o id solicitado.
     */
    @Operation(
            summary = "Buscar por ID",
            description = "Esse método vai ser excutado quando um ADMIN ou USER quiser buscar uma entrega pelo ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Entrega encontrada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Algo deu errado ao buscar essa entrega"
            )
    })
    @GetMapping("/api/entregas/{id}")
    public ResponseEntity<EntregaResponseDTO> buscarporID(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorID(id));
    }

    /**
     * Esse método é para excluir uma entrega de acordo com o id solicitado
     *
     * @param id id da entrega que irá ser excluida
     */
    @Operation(
            summary = "Excluir uma entrega",
            description = "Esse método vai ser excutado quando o ADMIN quiser excluir uma entrega especifica."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Entrega excluida com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "ALgo de errado na tentativa de excluir essa entrega"
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
