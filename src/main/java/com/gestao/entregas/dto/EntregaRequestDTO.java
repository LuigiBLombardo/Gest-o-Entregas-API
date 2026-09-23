package com.gestao.entregas.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Dados necessários para cadastrar um novo produto
 *
 * @param descricao descrição da entrega
 * @param status da entrega
 *
 * * */
public record EntregaRequestDTO(

        @Schema(
                description = "Descrição da Entrega",
                example = "Entrega de um computador para a RUA Antonio Carlos"
        )
        @NotBlank( message = "a descrição é obrigatório")
        @Size(min = 3,max = 255 , message = "a descrição deve possuir entre 3 e 255 caracteres")
        String descricao,

        @Schema(
                description = "Status da Entrega",
                example = "Ativo"
        )
        @NotBlank( message = "o status é obrigatório")
        String status
) {
}
