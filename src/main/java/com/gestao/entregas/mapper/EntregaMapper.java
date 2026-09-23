package com.gestao.entregas.mapper;

import com.gestao.entregas.dto.EntregaRequestDTO;
import com.gestao.entregas.dto.EntregaResponseDTO;
import com.gestao.entregas.dto.MotoristaRequestDTO;
import com.gestao.entregas.dto.MotoristaResponseDTO;
import com.gestao.entregas.entity.EntregaEntity;
import com.gestao.entregas.entity.MotoristaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntregaMapper {

    public EntregaEntity toEntity(EntregaRequestDTO requestDTO){

        return EntregaEntity.builder()
                .descricao(requestDTO.descricao())
                .status(requestDTO.status())
                .build();
    }

    public EntregaResponseDTO toResponse (EntregaEntity entrega){

        return new EntregaResponseDTO(
                entrega.getId(),
                entrega.getDescricao(),
                entrega.getStatus()
        );
    }

    public List<EntregaResponseDTO> toResponseList(List<EntregaEntity> entrega){
        return entrega.stream()
                .map(this::toResponse)
                .toList();
    }
}
