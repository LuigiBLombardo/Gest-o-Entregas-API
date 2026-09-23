package com.gestao.entregas.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record EntregaResponseDTO(

        @Schema(description = "ID da Entrega", example = "1")
        Long id,

        @Schema(description = "Descrição da Entrega", example = "Entrega de um computador para a RUA Antonio Carlos")
        String descricao,

        @Schema(description = "Status da Entrega", example = "ATIVO")
        String status
) {
}
