package com.gestao.entregas.mapper;

import com.gestao.entregas.dto.MotoristaRequestDTO;
import com.gestao.entregas.dto.MotoristaResponseDTO;
import com.gestao.entregas.entity.MotoristaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MotoristaMapper {

    public MotoristaEntity toEntity(MotoristaRequestDTO requestDTO){
        return MotoristaEntity.builder()
                .nome(requestDTO.nome())
                .cnh(requestDTO.cnh())
                .build();
    }

    public MotoristaResponseDTO toResponse (MotoristaEntity motorista){
        return new MotoristaResponseDTO(
                motorista.getId(),
                motorista.getNome(),
                motorista.getCnh()
        );
    }

    public List<MotoristaResponseDTO> toResponseList(List<MotoristaEntity> motorista){
        return motorista.stream()
                .map(this::toResponse)
                .toList();
    }
}
