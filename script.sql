CREATE TABLE medico(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(30) NOT NULL,
    telefone VARCHAR(12) NOT NULL,
    especialidade VARCHAR NOT NULL,
    ufEndereco VARCHAR(2) NOT NULL,
    cepEndereco VARCHAR(11) NOT NULL,
    logradouroEndereco VARCHAR(50) NOT NULL,
    numeroEndereco BIGINT,
    complementoEndereco VARCHAR,
    bairroEndereco VARCHAR(30) NOT NULL,
    cidadeEndereco VARCHAR(30) NOT NULL
);

CREATE TABLE paciente(

);