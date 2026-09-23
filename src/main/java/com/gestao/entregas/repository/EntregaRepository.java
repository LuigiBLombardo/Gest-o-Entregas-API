package com.gestao.entregas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EntregaRepository extends JpaRepository<EntregaRepository,Long> {

    @Query
    Optional<EntregaRepository> findByDescricao(String descricao);
}
