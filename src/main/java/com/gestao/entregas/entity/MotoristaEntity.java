package com.gestao.entregas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_motorista")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MotoristaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false,length = 100)
    private String nome;

    @Column(name = "cnh",nullable = false,length = 20,unique = true)
    private String cnh;

    @OneToMany(mappedBy = "motorista")
    private List<EntregaEntity> entregas;
}
