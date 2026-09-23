package com.gestao.entregas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username",nullable = false,unique = true,length = 50)
    String username;

    @Column(name = "password",nullable = false,length = 255)
    String password;

    @Column(name = "role",nullable = false,length = 20)
    String role;
}
