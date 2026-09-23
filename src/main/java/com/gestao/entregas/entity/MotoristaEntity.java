package com.gestao.entregas.entity;

import jakarta.persistence.*;
import lombok.*;

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
    Long id;

    @Column(name = "nome",nullable = false,length = 100)
    String nome;

    @Column(name = "cnh",nullable = false,length = 20,unique = true)
    String cnh;

}
