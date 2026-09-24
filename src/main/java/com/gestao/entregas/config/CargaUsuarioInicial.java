package com.gestao.entregas.config;

import com.gestao.entregas.entity.UsuarioEntity;
import com.gestao.entregas.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class CargaUsuarioInicial implements CommandLineRunner {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public CargaUsuarioInicial(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            List<UsuarioEntity> usuariosIniciais = List.of(
                    UsuarioEntity.builder()
                            .username("Luidao Lombardo")
                            .password(passwordEncoder.encode("87654321"))
                            .role("ADMIN")
                            .build(),
                    UsuarioEntity.builder()
                            .username("cherpinski")
                            .password(passwordEncoder.encode("98765432"))
                            .role("CLIENTE")
                            .build()
            );
            repository.saveAll(usuariosIniciais);
        }
    }
}
