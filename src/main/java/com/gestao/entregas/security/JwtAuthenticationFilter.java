package com.gestao.entregas.security;

import com.gestao.entregas.service.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final AuthService authService;

    public JwtAuthenticationFilter(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService  ;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request , HttpServletResponse response, FilterChain chain) throws ServletException , IOException{

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer")){
            String token = authHeader.substring(7);

            try {
                String username = jwtService.extractUsername(token);
                UserDetails userDetails = authService.loadUserByUsername(username);

                if (jwtService.isTokenValid(token, userDetails)){
                    var authtoken = new UsernamePasswordAuthenticationToken(
                            userDetails,null,userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authtoken);
                }
            }catch (Exception e){

            }
        }
        chain.doFilter(request, response);
    }
}
