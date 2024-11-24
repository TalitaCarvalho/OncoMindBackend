CREATE TABLE IF NOT EXISTS TB_CLINICAS (
    ID_LOCAL SERIAL PRIMARY KEY,
    NOME_CLINICA VARCHAR(255) NOT NULL,
    ENDERECO VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_MEDICO (
    ID_MEDICO SERIAL PRIMARY KEY,
    NOME_PROFISSIONAL VARCHAR(255) NOT NULL,
    CRM INT NOT NULL,
    CRM_ESTADO VARCHAR(50) NOT NULL,
    ESPECIALIDADE VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_PERFIL_USUARIO (
    ID_USUARIO SERIAL PRIMARY KEY,
    NOME VARCHAR(255) NOT NULL,
    CPF VARCHAR(11) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    SENHA VARCHAR(255) NOT NULL,
    ENDERECO VARCHAR(255),
    CEP VARCHAR(8),
    CIDADE VARCHAR(255),
    ESTADO VARCHAR(255),
    UF VARCHAR(2),
    TELEFONE VARCHAR(11),
    DATA_DE_NASCIMENTO DATE,
    PACIENTE BOOLEAN NOT NULL,
    FAMILIAR BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_AGENDAMENTO (
    ID_ATENDIMENTO SERIAL PRIMARY KEY,
    ID_USUARIO INT NOT NULL,
    TRATAMENTO VARCHAR(255) NOT NULL,
    HORARIO TIMESTAMP NOT NULL,
    ID_MEDICO INT NOT NULL,
    VIRTUAL BOOLEAN NOT NULL,
    PRESENCIAL BOOLEAN NOT NULL,
    ID_LOCAL INT NOT NULL,
    CONSTRAINT FK_AGENDAMENTO_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES TB_PERFIL_USUARIO(ID_USUARIO),
    CONSTRAINT FK_AGENDAMENTO_MEDICO FOREIGN KEY (ID_MEDICO) REFERENCES TB_MEDICO(ID_MEDICO),
    CONSTRAINT FK_AGENDAMENTO_LOCAL FOREIGN KEY (ID_LOCAL) REFERENCES TB_CLINICAS(ID_LOCAL)
);
