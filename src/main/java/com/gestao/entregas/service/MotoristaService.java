package com.gestao.entregas.service;

import com.gestao.entregas.dto.MotoristaResponseDTO;
import com.gestao.entregas.entity.MotoristaEntity;
import com.gestao.entregas.mapper.MotoristaMapper;
import com.gestao.entregas.repository.MotoristaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MotoristaService {

    private final MotoristaRepository repository;
    private final MotoristaMapper mapper;

    public MotoristaService(MotoristaRepository repository, MotoristaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<MotoristaResponseDTO> listar(){
        List<MotoristaEntity> motoristaEntities = repository.findAll();

        return mapper.toResponseList(motoristaEntities);
    }
}
