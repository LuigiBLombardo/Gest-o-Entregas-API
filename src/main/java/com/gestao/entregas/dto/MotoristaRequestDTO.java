package com.gestao.entregas.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Dados necessários para cadastrar um novo produto
 *
 * @param nome nome do motorista
 * @param cnh do motorista
 *
 * * */
public record MotoristaRequestDTO(
        @Schema(
                description = "Nome do Motorista",
                example = "Luigi"
        )
        @NotBlank( message = "o nome é obrigatório")
        @Size(min = 3,max = 100 , message = "o nome deve possuir entre 3 e 100 caracteres")
        String nome,

        @Schema(
                description = "CNH do Motorista",
                example = "02426730578"
        )
        @NotBlank( message = "a CNH é obrigatória")
        @Size(min = 20,max = 20 , message = "a CNH deve possuir 20 caracteres")
        String cnh

) {
}
