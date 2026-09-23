package com.gestao.entregas.service;

import com.gestao.entregas.dto.EntregaResponseDTO;
import com.gestao.entregas.dto.MotoristaResponseDTO;
import com.gestao.entregas.entity.EntregaEntity;
import com.gestao.entregas.entity.MotoristaEntity;
import com.gestao.entregas.mapper.EntregaMapper;
import com.gestao.entregas.repository.EntregaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntregaService {

    private final EntregaRepository repository;
    private final EntregaMapper mapper;

    public EntregaService(EntregaRepository repository, EntregaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public EntregaResponseDTO buscarPorID(Long id){
        return repository.findById(id)
                .map(mapper:: toResponse)
                .orElseThrow(() -> new RuntimeException("Esse motorista não foi encontrado no sistema"));
    }

    @Transactional
    public void remover(Long id){
        EntregaEntity entrega = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));

        repository.delete(entrega);
    }
}
