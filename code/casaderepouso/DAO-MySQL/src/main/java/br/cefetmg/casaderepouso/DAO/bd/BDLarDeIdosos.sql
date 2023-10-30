CREATE DATABASE IF NOT EXISTS BDLarDeIdosos;
USE BDLarDeIdosos;
CREATE TABLE casa_de_repouso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    comodos INT NOT NULL,
    moradores INT NOT NULL,
    limite_de_moradores INT NOT NULL,
    estado_do_comodo ENUM('Vago', 'Ocupado', 'Manutenção', 'Outro') NOT NULL
);
CREATE TABLE visitantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    rg VARCHAR(20) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    vinculo_com_morador VARCHAR(100) NOT NULL,
    data_e_hora_de_visita DATETIME NOT NULL
);
CREATE TABLE morador (
    nome VARCHAR(255) NOT NULL,
    condicoes TEXT,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(12) NOT NULL,
    datanascimento DATE NOT NULL,
    responsavel VARCHAR(255),
    nome_mae VARCHAR(255) NOT NULL
    estado VARCHAR(255) NOT NULL
);
CREATE TABLE responsavel (
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
CREATE TABLE funcionario (
    id VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(12) NOT NULL,
    telefone VARCHAR(20),
    nascimento DATE,
    endereco TEXT,
    pis VARCHAR(20) NOT NULL,
    funcao VARCHAR(255) NOT NULL,
    periodoTrabalho VARCHAR(255) NOT NULL
);
CREATE TABLE gerente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(12) NOT NULL,
    nascimento DATE NOT NULL,
    telefone VARCHAR(20),
    endereco TEXT
);
CREATE TABLE medicamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    tarja ENUM('SEM_TARJA', 'VERMELHA', 'AMARELA', 'PRETA';) NOT NULL,
    validade DATE NOT NULL,
    morador VARCHAR(14) NOT NULL,
    dose VARCHAR(255),
    ultimaAplicacao DATETIME NOT NULL,
    intervalo INT NOT NULL,
    condicao ENUM('COMPRADO','SOLICITADO','ESGOTADO'),
    FOREIGN KEY (morador) REFERENCES morador(id)
);
CREATE TABLE profissional_de_saude (
    id INT AUTO_INCREMENTta PRIMARY KEY,
    registro_medico VARCHAR(20) NOT NULL,
    especializacao VARCHAR(255) NOT NULL
);
CREATE TABLE prontuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    morador INT NOT NULL,
    profissional_de_saude INT NOT NULL,
    relatorios TEXT,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    FOREIGN KEY (morador) REFERENCES morador(id),
    FOREIGN KEY (funcionario) REFERENCES funcionario(id)
);
CREATE TABLE consulta (
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
CREATE TABLE receita_medica (
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
CREATE TABLE dieta_comum (
    id INT AUTO_INCREMENT PRIMARY KEY,
    profissional_de_saude INT NOT NULL,
    refeicao TEXT NOT NULL,
    FOREIGN KEY (profissional_de_saude) REFERENCES profissional_de_saude(id)
);
CREATE TABLE dieta_especifica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    profissional_de_saude INT NOT NULL,
    morador INT NOT NULL,
    refeicao TEXT NOT NULL,
    restricoes TEXT,
    horas_das_refeicoes TEXT,
    FOREIGN KEY (profissional_de_saude) REFERENCES profissional_de_saude(id),
    FOREIGN KEY (morador) REFERENCES morador(id)
);

