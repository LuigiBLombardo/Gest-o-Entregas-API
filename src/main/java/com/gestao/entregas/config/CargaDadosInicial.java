package com.gestao.entregas.config;

import com.gestao.entregas.entity.MotoristaEntity;
import com.gestao.entregas.repository.EntregaRepository;
import com.gestao.entregas.repository.MotoristaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CargaDadosInicial implements CommandLineRunner {

    private final MotoristaRepository motoristaRepository;
    private final EntregaRepository entregaRepository;

    public CargaDadosInicial(MotoristaRepository motoristaRepository , EntregaRepository entregaRepository){
        this.motoristaRepository = motoristaRepository;
        this.entregaRepository = entregaRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        if (motoristaRepository.count() == 0){
            List<MotoristaEntity> motoristasInciais = List.of(
                    MotoristaEntity.builder()
                            .nome("Guilherme")
                            .cnh("02426730578")
                            .build(),
                    MotoristaEntity.builder()
                            .nome("Eduardo")
                            .cnh("01446739578")
                            .build(),
                    MotoristaEntity.builder()
                            .nome("Luigi")
                            .cnh("11246439578")
                            .build()
            );
        }
    }
}
