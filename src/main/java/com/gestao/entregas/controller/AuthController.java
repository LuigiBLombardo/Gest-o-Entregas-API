package com.gestao.entregas.controller;

import com.gestao.entregas.dto.LoginRequest;
import com.gestao.entregas.security.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller REST responsável pelo endpoint de autenticação de usuários.
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Endpoints de autenticação e geração de tokens JWT")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    /**
     * Realiza a autenticação das credenciais fornecidas e retorna o token JWT gerado.
     *
     * @param request DTO com usuário e senha do requisitante.
     * @return Map contendo o token no campo "token".
     */
    @Operation(
            summary = "Realizar Login",
            description = "Valida as credenciais enviadas e retorna um token JWT para uso no cabeçalho Authorization das demais requisições."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Autenticação realizada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Credenciais inválidas ou não encontradas"
            )
    })
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        return Map.of("token", token);
    }
}