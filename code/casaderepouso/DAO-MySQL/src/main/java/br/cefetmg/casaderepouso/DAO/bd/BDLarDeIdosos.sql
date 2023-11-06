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
    data_e_hora_de_visita DATETIME
);
CREATE TABLE IF NOT EXISTS morador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(14),
    rg VARCHAR(12),
    datanascimento VARCHAR(20),
    planomedico VARCHAR(255),
    responsavel VARCHAR(255),
    nome_mae VARCHAR(255),
    endereco TEXT,
    condicoes TEXT,
    estado VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS responsavel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(12) NOT NULL,
    telefone VARCHAR(20),
    datanascimento DATE,
    endereco TEXT,
    morador_responsavel INT,
    FOREIGN KEY (morador_responsavel) REFERENCES morador(id)
);
CREATE TABLE IF NOT EXISTS funcionario (
    id VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(12) NOT NULL,
    telefone VARCHAR(20),
    nascimento VARCHAR(20),
    endereco TEXT,
    pis VARCHAR(255) NOT NULL,
    funcao VARCHAR(255) NOT NULL,
    periodoTrabalho VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS gerente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(12) NOT NULL,
    nascimento DATE NOT NULL,
    telefone VARCHAR(20),
    endereco TEXT
);
CREATE TABLE IF NOT EXISTS evento (
    id VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    rg VARCHAR(12) NOT NULL,
    descricao VARCHAR(255),
    lugar VARCHAR(255),
    dia VARCHAR(20),
    horario VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS medicamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    tarja ENUM('SEM_TARJA', 'VERMELHA', 'AMARELA', 'PRETA') NOT NULL,
    validade DATE NOT NULL,
    morador INT NOT NULL,
    dose VARCHAR(255),
    ultimaAplicacao DATETIME NOT NULL,
    intervalo INT NOT NULL,
    FOREIGN KEY (morador) REFERENCES morador(id)
);
CREATE TABLE IF NOT EXISTS profissional_de_saude (
    id INT AUTO_INCREMENT PRIMARY KEY,
    registro_medico VARCHAR(20) NOT NULL,
    especializacao VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS prontuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    morador INT NOT NULL,
    profissional_de_saude INT NOT NULL,
    relatorios TEXT,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    funcionario VARCHAR(255) NOT NULL,
    FOREIGN KEY (morador) REFERENCES morador(id),
    FOREIGN KEY (funcionario) REFERENCES funcionario(id)
);
CREATE TABLE IF NOT EXISTS consulta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    morador INT NOT NULL,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    nivel_de_emergencia ENUM('Baixo', 'Médio', 'Alto', 'Emergência') NOT NULL,
    profissional_de_saude INT NOT NULL,
    especializacao VARCHAR(255) NOT NULL,
    FOREIGN KEY (morador) REFERENCES morador(id),
    FOREIGN KEY (profissional_de_saude) REFERENCES profissional_de_saude(id)
);
CREATE TABLE IF NOT EXISTS receita_medica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    profissional_de_saude INT NOT NULL,
    morador INT NOT NULL,
    medicamentos TEXT,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    quantidade INT NOT NULL,
    validade DATE NOT NULL,
    FOREIGN KEY (profissional_de_saude) REFERENCES profissional_de_saude(id),
    FOREIGN KEY (morador) REFERENCES morador(id)
);
CREATE TABLE IF NOT EXISTS dieta_comum (
    id INT AUTO_INCREMENT PRIMARY KEY,
    profissional_de_saude INT NOT NULL,
    refeicao TEXT NOT NULL,
    FOREIGN KEY (profissional_de_saude) REFERENCES profissional_de_saude(id)
);
CREATE TABLE IF NOT EXISTS dieta_especifica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    profissional_de_saude INT NOT NULL,
    morador INT NOT NULL,
    refeicao TEXT NOT NULL,
    restricoes TEXT,
    horas_das_refeicoes TEXT,
    FOREIGN KEY (profissional_de_saude) REFERENCES profissional_de_saude(id),
    FOREIGN KEY (morador) REFERENCES morador(id)
);

