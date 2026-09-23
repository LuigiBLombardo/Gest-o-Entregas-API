-- Tabela de Usuários para Autenticação Security/JWT
CREATE TABLE tb_usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Tabela de Motoristas
CREATE TABLE tb_motorista (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnh VARCHAR(20) NOT NULL UNIQUE
);

-- Tabela de Entregas (Relacionamento com Motorista)
CREATE TABLE tb_entrega (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    status VARCHAR(30) NOT NULL,
    motorista_id BIGINT,
    FOREIGN KEY (motorista_id) REFERENCES tb_motorista(id)
);