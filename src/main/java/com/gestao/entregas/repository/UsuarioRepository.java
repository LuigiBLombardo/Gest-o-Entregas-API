package com.gestao.entregas.repository;

import com.gestao.entregas.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity , Long> {

    @Query
    Optional<UsuarioEntity> findByUsername (String username);
}
