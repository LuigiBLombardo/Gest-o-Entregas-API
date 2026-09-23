package com.gestao.entregas.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Representação pública de um produto retornado pela API
 *
 * @param nome nome do motorista
 * @param cnh cnh do motorista
 * */
public record MotoristaResponseDTO(

        @Schema(description = "ID do Motorista", example = "1")
        Long id,

        @Schema(description = "Nome do Motorista", example = "Luigi")
        String nome,

        @Schema(description = "CNH do Motorista", example = "02426730578")
        String cnh
) {
}
