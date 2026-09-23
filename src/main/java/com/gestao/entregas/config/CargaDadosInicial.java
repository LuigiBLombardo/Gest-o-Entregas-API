package com.gestao.entregas.config;

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
            List<Motorista> motoristasInciais = List.of(
                    Motorista.builder()
                            .nome("")
            )
        }
    }
}
