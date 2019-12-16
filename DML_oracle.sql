---------------- { Tables } -----------------------------------------------------
CREATE TABLE TipoPessoa (
  id                   NUMBER        NOT NULL,
  descricao            VARCHAR(50)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE TipoLogradouro (
  codigo               NUMBER        NOT NULL,
  descricao            VARCHAR(30)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE Logradouro (
  id                   NUMBER        NOT NULL,
  nome                 VARCHAR(150)  NOT NULL,
  codigoTipoLogradouro NUMBER        NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE Moeda (
  codigo               NUMBER        NOT NULL,
  nome                 VARCHAR(20)   NOT NULL,
  simbolo              VARCHAR(5)    NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE Nacao (
  codigo               NUMBER        NOT NULL,
  nome                 VARCHAR(50)   NOT NULL,
  nome_completo        VARCHAR(150)  NOT NULL,
  lingua               VARCHAR(50)   NOT NULL,
  codigoISO            VARCHAR(3)    NOT NULL,
  codigoMoeda          NUMBER        NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE Categoria (
  id                   NUMBER        NOT NULL,
  nome                 VARCHAR(50)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE TipoTitulo (
  id                   NUMBER        NOT NULL,
  nome                 VARCHAR(50)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE Estado (
  id                   NUMBER        NOT NULL,
  nome                 VARCHAR(50)   NOT NULL,
  sigla                VARCHAR(2)    NOT NULL,
  codigoNacao          NUMBER        NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE Cidade (
  id                   NUMBER        NOT NULL,
  nome                 VARCHAR(50)   NOT NULL,
  idEstado             NUMBER        NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE CEP (
  codigo               VARCHAR(8)    NOT NULL,
  idCidade             NUMBER        NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE NivelAcesso(
  id                   NUMBER        NOT NULL,
  descricao            VARCHAR(50)   NOT NULL DEFAULT 'Padrão',
  prioridade           NUMBER        NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE Usuario (
  id                   NUMBER        NOT NULL,
  nome                 VARCHAR(80)   NOT NULL,
  documento            VARCHAR(14)   NOT NULL,
  telefone             VARCHAR(50),
  email                VARCHAR(100)  NOT NULL,
  senha                VARCHAR(50)   NOT NULL,
  idTipoPessoa         NUMBER        NOT NULL,
  idNivelAcesso        NUMBER        NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE CodigoAcesso (
  id                   NUMBER        NOT NULL,
  codigo               VARCHAR(10)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE Endereco (
  id                   NUMBER        NOT NULL,
  numero               NUMBER        NOT NULL,
  bairro               VARCHAR(100),
  complemento          VARCHAR(50),
  referencia           VARCHAR(200),
  codigoCEP            NUMBER        NOT NULL,
  idLogradouro         NUMBER        NOT NULL,
  idUsuario            NUMBER        NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

CREATE TABLE Titulo (
  id                   NUMBER        NOT NULL,
  numeroTitulo         NUMBER,
  idTipoTitulo         NUMBER        NOT NULL,
  idUsuario            NUMBER        NOT NULL,
  idCategoria          NUMBER        NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);


CREATE TABLE Parcela (
  id                   NUMBER        NOT NULL,
  idTitulo             NUMBER        NOT NULL,
  valor                NUMBER(14,2)  NOT NULL,
  dataPagamento        TIMESTAMP,
  dataVencimento       DATE          NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT SYSTIMESTAMP,
  ativo                VARCHAR(1)    NOT NULL DEFAULT 'S',
  excluido             VARCHAR(1)    NOT NULL DEFAULT 'N'
);

-------------- { Constraints } ----------------
-------------- { Primary Key } ---------------
ALTER TABLE TipoPessoa
  ADD CONSTRAINT tipopessoa_pk
  PRIMARY KEY (id);

ALTER TABLE TipoLogradouro
  ADD CONSTRAINT tipologradouro_pk
  PRIMARY KEY (codigo);

ALTER TABLE Logradouro
  ADD CONSTRAINT logradouro_pk
  PRIMARY KEY (id);

ALTER TABLE Moeda
  ADD CONSTRAINT moeda_pk
  PRIMARY KEY (codigo);

ALTER TABLE Nacao
  ADD CONSTRAINT nacao_pk
  PRIMARY KEY (codigo);

ALTER TABLE Categoria
  ADD CONSTRAINT categoria_pk
  PRIMARY KEY (id);

ALTER TABLE TipoTitulo
  ADD CONSTRAINT tipotitulo_pk
  PRIMARY KEY (id);

ALTER TABLE Estado
  ADD CONSTRAINT estado_pk
  PRIMARY KEY (id);

ALTER TABLE Cidade
  ADD CONSTRAINT cidade_pk
  PRIMARY KEY (id);

ALTER TABLE CEP
  ADD CONSTRAINT cep_pk
  PRIMARY KEY (codigo);

ALTER TABLE NivelAcesso
  ADD CONSTRAINT nivelacesso_pk
  PRIMARY KEY (id);

ALTER TABLE Usuario
  ADD CONSTRAINT usuario_pk
  PRIMARY KEY (id);

ALTER TABLE CodigoAcesso
  ADD CONSTRAINT codigoacesso_pk
  PRIMARY KEY (id)

ALTER TABLE Endereco
  ADD CONSTRAINT endereco_pk
  PRIMARY KEY (id);

ALTER TABLE Titulo
  ADD CONSTRAINT titulo_pk
  PRIMARY KEY (id);

ALTER TABLE Parcela
  ADD CONSTRAINT parcela_pk
  PRIMARY KEY (id);

-------------- { Foreign Key } --------------
ALTER TABLE Logradouro
  ADD CONSTRAINT logradouro_tipoLogradouro_fk
  FOREIGN KEY (codigoTipoLogradouro)
  REFERENCES TipoLogradouro(codigo);

ALTER TABLE Nacao
  ADD CONSTRAINT nacao_moeda_fk
  FOREIGN KEY (codigoMoeda)
  REFERENCES Moeda(codigo);

ALTER TABLE Estado
  ADD CONSTRAINT estado_nacao_fk
  FOREIGN KEY (codigoNacao)
  REFERENCES Nacao(codigo);

ALTER TABLE Cidade
  ADD CONSTRAINT cidade_estado_fk
  FOREIGN KEY (idEstado)
  REFERENCES Estado(id);

ALTER TABLE CEP
  ADD CONSTRAINT cep_cidade_fk
  FOREIGN KEY (idCidade)
  REFERENCES Cidade(id);

ALTER TABLE Usuario
  ADD CONSTRAINT usuario_tipopessoa_fk
  FOREIGN KEY (idTipoPessoa)
  REFERENCES TipoPessoa(id);

ALTER TABLE Usuario
  ADD CONSTRAINT usuario_nivelacesso_fk
  FOREIGN KEY (idNivelAcesso)
  REFERENCES NivelAcesso(id);

ALTER TABLE Endereco
  ADD CONSTRAINT endereco_cep_fk
  FOREIGN KEY (codigoCEP)
  REFERENCES CEP(codigo);

ALTER TABLE Endereco
  ADD CONSTRAINT endereco_logradouro_fk
  FOREIGN KEY (idLogradouro)
  REFERENCES Logradouro(id);

ALTER TABLE Endereco
  ADD CONSTRAINT endereco_usuario_fk
  FOREIGN KEY (idUsuario)
  REFERENCES Usuario(id);

ALTER TABLE Titulo
  ADD CONSTRAINT titulo_tipotitulo_fk
  FOREIGN KEY (idTipoTitulo)
  REFERENCES TipoTitulo(id);

ALTER TABLE Titulo
  ADD CONSTRAINT titulo_usuario_fk
  FOREIGN KEY (idUsuario)
  REFERENCES Usuario(id);

ALTER TABLE Titulo
  ADD CONSTRAINT titulo_categoria_fk
  FOREIGN KEY (idCategoria)
  REFERENCES Categoria(id);

ALTER TABLE Parcela
  ADD CONSTRAINT parcela_titulo_fk
  FOREIGN KEY (idTitulo)
  REFERENCES Titulo(id);
