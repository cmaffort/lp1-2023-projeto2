CREATE DATABASE IF NOT EXISTS BDLarDeIdosos;
USE BDLarDeIdosos;
CREATE TABLE IF NOT EXISTS casa_de_repouso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    comodos INT NOT NULL,
    moradores INT NOT NULL,
    limite_de_moradores INT NOT NULL,
    estado_do_comodo ENUM('Vago', 'Ocupado', 'Manutenção', 'Outro') NOT NULL
);
CREATE TABLE IF NOT EXISTS visitantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    rg VARCHAR(20),
    telefone VARCHAR(15),
    vinculo_com_morador VARCHAR(100),
    morador VARCHAR(100),
    data_visita VARCHAR(255),
    hora_visita VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS morador (
    nome VARCHAR(255),
    cpf VARCHAR(14) PRIMARY KEY,
    datanascimento VARCHAR(20),
    planomedico VARCHAR(255),
    responsavel VARCHAR(255),
    nome_mae VARCHAR(255),
    endereco VARCHAR(255),
    condicoes VARCHAR(255),
    estado VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS responsavel (
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(12) NOT NULL,
    telefone VARCHAR(20),
    endereco TEXT,
    morador_responsavel VARCHAR(14),
    senha TEXT

);
CREATE TABLE IF NOT EXISTS funcionario (
    id VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(20) NOT NULL,
    telefone VARCHAR(20),
    nascimento VARCHAR(255),
    endereco TEXT,
    pis VARCHAR(255),
    funcao VARCHAR(255),
    periodoTrabalho VARCHAR(255),
    senha TEXT
);
CREATE TABLE IF NOT EXISTS gerente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(20) NOT NULL,
    nascimento DATE NOT NULL,
    telefone VARCHAR(20),
    endereco TEXT
);
CREATE TABLE IF NOT EXISTS evento (
    id VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    rg VARCHAR(20) NOT NULL,
    descricao VARCHAR(255),
    lugar VARCHAR(255),
    dia VARCHAR(20),
    horario VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS saida (
    id VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    motivo TEXT,
    diaSaida VARCHAR(255),
    horarioSaida VARCHAR(255),
    diaVolta VARCHAR(255),
    horarioVolta VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS medicamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    tarja ENUM('SEM_TARJA', 'VERMELHA', 'AMARELA', 'PRETA') NOT NULL,
    validade DATE NOT NULL,
    morador VARCHAR(14) NOT NULL,
    dose VARCHAR(255),
    ultimaAplicacao DATETIME NOT NULL,
    intervalo INT NOT NULL,
    FOREIGN KEY (morador) REFERENCES morador(cpf)
);
CREATE TABLE IF NOT EXISTS profissional_de_saude (
    id INT AUTO_INCREMENT PRIMARY KEY,
    registro_medico VARCHAR(20) NOT NULL,
    especializacao VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS prontuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    morador VARCHAR(14) NOT NULL,
    profissional_de_saude INT NOT NULL,
    relatorios TEXT,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    funcionario VARCHAR(255) NOT NULL,
    FOREIGN KEY (morador) REFERENCES morador(cpf),
    FOREIGN KEY (funcionario) REFERENCES funcionario(id)
);
CREATE TABLE IF NOT EXISTS consulta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    morador VARCHAR(255) NOT NULL,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    tipo VARCHAR (255),
    profissional_de_saude VARCHAR(255) NOT NULL,
    especializacao VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS receita_medica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    profissional_de_saude TEXT NOT NULL,
    morador TEXT NOT NULL,
    medicamentos TEXT,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    quantidade INT NOT NULL,
    validade DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS refeicao (
   cpf VARCHAR(14),
   hora VARCHAR(20),
   cardapio VARCHAR(255),
   tipo VARCHAR(255),
   dia VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS cartao_credito (
    cpf VARCHAR (14),
    numero_cartao VARCHAR (20),
    nome_cartao VARCHAR (255),
    validade VARCHAR (6),
    cardtype VARCHAR (10)
);

CREATE TABLE IF NOT EXISTS atualizacao(
    cpf VARCHAR(14),
    dados TEXT,
    momento VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS mensalidade(
    cpfMorador VARCHAR(14),
    cpfResponsavel VARCHAR(14),
    inicio VARCHAR(20),
    fim VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS despesas(
	destinatario VARCHAR(255),
    pagante VARCHAR(255),
    telefone VARCHAR(20),
    identidade VARCHAR(255),
    dia VARCHAR(255),
    hora VARCHAR(255),
    descricao VARCHAR(255),
    valor VARCHAR(255)
    );
CREATE TABLE IF NOT EXISTS equipamento (
   tipo VARCHAR (255) NOT NULL,
   preco VARCHAR (255) NOT NULL,
   quantidade INT NOT NULL,
   estado VARCHAR (255) NOT NULL
);
