CREATE TABLE medico(
    id SERIAL PRIMARY KEY,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
    crm VARCHAR NOT NULL,
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
    id SERIAL PRIMARY KEY,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    uf_endereco CHAR(2) NOT NULL,
    cep_endereco VARCHAR(8) NOT NULL,
    logradouro_endereco VARCHAR(100) NOT NULL,
    numero_endereco BIGINT NOT NULL,
    complemento_endereco VARCHAR(50),
    bairro_endereco VARCHAR(50) NOT NULL,
    cidade_endereco VARCHAR(50) NOT NULL
);

CREATE TABLE consulta(
    id SERIAL PRIMARY KEY,
    medico_id INT NOT NULL,
    paciente_id INT NOT NULL,
    data TIMESTAMP NOT NULL,
    motivo_cancelamento TEXT,
    cancelada boolean default false;
);
