package com.gestao.entregas.repository;

import com.gestao.entregas.entity.EntregaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Repositório responsável pelo acesso dos dados de Entregas
 * */

public interface EntregaRepository extends JpaRepository<EntregaEntity,Long> {

    @Query
    Optional<EntregaRepository> findByDescricao(String descricao);
}
