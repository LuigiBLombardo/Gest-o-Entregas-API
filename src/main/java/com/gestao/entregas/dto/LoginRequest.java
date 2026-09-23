package com.gestao.entregas.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Record DTO para recebimento das credenciais de autenticação no endpoint de login.
 *
 * @param username Nome de usuário cadastrado.
 * @param password Senha de acesso do usuário.
 */
@Schema(description = "Objeto contendo os dados de credenciais para login")
public record LoginRequest(
        @Schema(description = "Nome de usuário para autenticação", example = "admin")
        String username,

        @Schema(description = "Senha de acesso", example = "senha123")
        String password
) {}