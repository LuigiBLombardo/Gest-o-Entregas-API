package com.gestao.entregas.repository;

import com.gestao.entregas.entity.MotoristaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<MotoristaEntity,Long> {

    @Query
    Optional<MotoristaEntity> findByCnh(String cnh);
}
