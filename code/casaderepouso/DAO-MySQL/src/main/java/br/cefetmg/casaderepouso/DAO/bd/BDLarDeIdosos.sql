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
    data_visita VARCHAR(255),
    hora_visita VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS morador (
    nome VARCHAR(255),
    telefone VARCHAR(20),
    datanascimento DATE,
    endereco TEXT,
    morador_responsavel VARCHAR(14),
    FOREIGN KEY (morador_responsavel) REFERENCES morador(CPF)
);
CREATE TABLE IF NOT EXISTS funcionario (
    id VARCHAR(255) PRIMARY KEY,
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
	@@ -90,41 +89,45 @@ CREATE TABLE IF NOT EXISTS profissional_de_saude (

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
    profissional_de_saude INT NOT NULL,
    morador VARCHAR(14) NOT NULL,
    medicamentos TEXT,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    quantidade INT NOT NULL,
    validade DATE NOT NULL,
    FOREIGN KEY (profissional_de_saude) REFERENCES profissional_de_saude(id),
    FOREIGN KEY (morador) REFERENCES morador(cpf)
);

CREATE TABLE IF NOT EXISTS refeicao (
   cpf VARCHAR(14),
   hora VARCHAR(20),
   cardapio VARCHAR(255),
   tipo VARCHAR(255),
   dia VARCHAR(20)
);


