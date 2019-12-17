---------------- { Sequences } -------------------
CREATE SEQUENCE seq_tipopessoa_id         START 1;
CREATE SEQUENCE seq_tipologradouro_codigo START 1;
CREATE SEQUENCE seq_logradouro_id         START 1;
CREATE SEQUENCE seq_moeda_codigo          START 1;
CREATE SEQUENCE seq_nacao_codigo          START 1;
CREATE SEQUENCE seq_categoria_id          START 1;
CREATE SEQUENCE seq_tipotitulo_id         START 1;
CREATE SEQUENCE seq_estado_id             START 1;
CREATE SEQUENCE seq_cidade_id             START 1;
CREATE SEQUENCE seq_nivelacesso_id        START 1;
CREATE SEQUENCE seq_usuario_id            START 1;
CREATE SEQUENCE seq_codigoacesso_id       START 1;
CREATE SEQUENCE seq_endereco_id           START 1;
CREATE SEQUENCE seq_titulo_id             START 1;
CREATE SEQUENCE seq_parcela_id            START 1;

---------------- { Tables } -----------------------------------------------------
CREATE TABLE TipoPessoa (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_tipopessoa_id'),
  descricao            VARCHAR(50)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE TipoLogradouro (
  codigo               INTEGER       NOT NULL DEFAULT nextval('seq_tipologradouro_codigo'),
  descricao            VARCHAR(30)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE Logradouro (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_logradouro_id'),
  nome                 VARCHAR(150)  NOT NULL,
  codigoTipoLogradouro INTEGER       NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE Moeda (
  codigo               INTEGER       NOT NULL DEFAULT nextval('seq_moeda_codigo'),
  nome                 VARCHAR(20)   NOT NULL,
  simbolo              VARCHAR(5)    NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE Nacao (
  codigo               INTEGER       NOT NULL DEFAULT nextval('seq_nacao_codigo'),
  nome                 VARCHAR(50)   NOT NULL,
  nome_completo        VARCHAR(150)  NOT NULL,
  lingua               VARCHAR(50)   NOT NULL,
  codigoISO            VARCHAR(3)    NOT NULL,
  codigoMoeda          INTEGER       NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE Categoria (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_categoria_id'),
  nome                 VARCHAR(50)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE TipoTitulo (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_tipotitulo_id'),
  nome                 VARCHAR(50)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE Estado (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_estado_id'),
  nome                 VARCHAR(50)   NOT NULL,
  sigla                VARCHAR(10)    NOT NULL, -- Devido as regiões japonesas, o limite foi aumentado
  codigoNacao          INTEGER       NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE Cidade (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_cidade_id'),
  nome                 VARCHAR(50)   NOT NULL,
  idEstado             INTEGER       NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE CEP (
  codigo               VARCHAR(8)    NOT NULL,
  idCidade             INTEGER       NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE NivelAcesso(
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_nivelacesso_id'),
  descricao            VARCHAR(50)   NOT NULL DEFAULT 'Padrão',
  prioridade           INTEGER       NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE Usuario (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_usuario_id'),
  nome                 VARCHAR(80)   NOT NULL,
  documento            VARCHAR(14)   NOT NULL,
  telefone             VARCHAR(50),
  email                VARCHAR(100)  NOT NULL,
  senha                VARCHAR(50)   NOT NULL,
  idTipoPessoa         INTEGER       NOT NULL,
  idNivelAcesso        INTEGER       NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE CodigoAcesso (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_codigoacesso_id'),
  codigo               VARCHAR(10)   NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE Endereco (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_endereco_id'),
  numero               INTEGER       NOT NULL,
  bairro               VARCHAR(100),
  complemento          VARCHAR(50),
  referencia           VARCHAR(200),
  codigoCEP            VARCHAR(8)    NOT NULL,
  idLogradouro         INTEGER       NOT NULL,
  idUsuario            INTEGER       NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE Titulo (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_titulo_id'),
  numeroTitulo         INTEGER,
  idTipoTitulo         INTEGER       NOT NULL,
  idUsuario            INTEGER       NOT NULL,
  idCategoria          INTEGER       NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);


CREATE TABLE Parcela (
  id                   INTEGER       NOT NULL DEFAULT nextval('seq_parcela_id'),
  idTitulo             INTEGER       NOT NULL,
  valor                NUMERIC(14,2) NOT NULL,
  dataPagamento        TIMESTAMP,
  dataVencimento       DATE          NOT NULL,
  dataCriacao          TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dataAlteracao        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo                BOOLEAN       NOT NULL DEFAULT TRUE,
  excluido             BOOLEAN       NOT NULL DEFAULT FALSE
);

-------------- { Constraints } ----------------
-------------- { Primary Key } ---------------
ALTER TABLE TipoPessoa      ADD CONSTRAINT tipopessoa_pk      PRIMARY KEY (id);
ALTER TABLE TipoLogradouro  ADD CONSTRAINT tipologradouro_pk  PRIMARY KEY (codigo);
ALTER TABLE Logradouro      ADD CONSTRAINT logradouro_pk      PRIMARY KEY (id);
ALTER TABLE Moeda           ADD CONSTRAINT moeda_pk           PRIMARY KEY (codigo);
ALTER TABLE Nacao           ADD CONSTRAINT nacao_pk           PRIMARY KEY (codigo);
ALTER TABLE Categoria       ADD CONSTRAINT categoria_pk       PRIMARY KEY (id);
ALTER TABLE TipoTitulo      ADD CONSTRAINT tipotitulo_pk      PRIMARY KEY (id);
ALTER TABLE Estado          ADD CONSTRAINT estado_pk          PRIMARY KEY (id);
ALTER TABLE Cidade          ADD CONSTRAINT cidade_pk          PRIMARY KEY (id);
ALTER TABLE CEP             ADD CONSTRAINT cep_pk             PRIMARY KEY (codigo);
ALTER TABLE NivelAcesso     ADD CONSTRAINT nivelacesso_pk     PRIMARY KEY (id);
ALTER TABLE Usuario         ADD CONSTRAINT usuario_pk         PRIMARY KEY (id);
ALTER TABLE CodigoAcesso    ADD CONSTRAINT codigoacesso_pk    PRIMARY KEY (id);
ALTER TABLE Endereco        ADD CONSTRAINT endereco_pk        PRIMARY KEY (id);
ALTER TABLE Titulo          ADD CONSTRAINT titulo_pk          PRIMARY KEY (id);
ALTER TABLE Parcela         ADD CONSTRAINT parcela_pk         PRIMARY KEY (id);
-------------- { Foreign Key } --------------
ALTER TABLE Logradouro ADD CONSTRAINT logradouro_tipoLogradouro_fk  FOREIGN KEY (codigoTipoLogradouro)  REFERENCES TipoLogradouro(codigo);
ALTER TABLE Nacao      ADD CONSTRAINT nacao_moeda_fk                FOREIGN KEY (codigoMoeda)           REFERENCES Moeda(codigo);
ALTER TABLE Estado     ADD CONSTRAINT estado_nacao_fk               FOREIGN KEY (codigoNacao)           REFERENCES Nacao(codigo);
ALTER TABLE Cidade     ADD CONSTRAINT cidade_estado_fk              FOREIGN KEY (idEstado)              REFERENCES Estado(id);
ALTER TABLE CEP        ADD CONSTRAINT cep_cidade_fk                 FOREIGN KEY (idCidade)              REFERENCES Cidade(id);
ALTER TABLE Usuario    ADD CONSTRAINT usuario_tipopessoa_fk         FOREIGN KEY (idTipoPessoa)          REFERENCES TipoPessoa(id);
ALTER TABLE Usuario    ADD CONSTRAINT usuario_nivelacesso_fk        FOREIGN KEY (idNivelAcesso)         REFERENCES NivelAcesso(id);
ALTER TABLE Endereco   ADD CONSTRAINT endereco_cep_fk               FOREIGN KEY (codigoCEP)             REFERENCES CEP(codigo);
ALTER TABLE Endereco   ADD CONSTRAINT endereco_logradouro_fk        FOREIGN KEY (idLogradouro)          REFERENCES Logradouro(id);
ALTER TABLE Endereco   ADD CONSTRAINT endereco_usuario_fk           FOREIGN KEY (idUsuario)             REFERENCES Usuario(id);
ALTER TABLE Titulo     ADD CONSTRAINT titulo_tipotitulo_fk          FOREIGN KEY (idTipoTitulo)          REFERENCES TipoTitulo(id);
ALTER TABLE Titulo     ADD CONSTRAINT titulo_usuario_fk             FOREIGN KEY (idUsuario)             REFERENCES Usuario(id);
ALTER TABLE Titulo     ADD CONSTRAINT titulo_categoria_fk           FOREIGN KEY (idCategoria)           REFERENCES Categoria(id);
ALTER TABLE Parcela    ADD CONSTRAINT parcela_titulo_fk             FOREIGN KEY (idTitulo)              REFERENCES Titulo(id);
------------------ { Views } -----------------
CREATE VIEW vw_usuarios_ativos AS
  SELECT id, nome, documento, telefone, email, senha, idtipopessoa, idnivelacesso, datacriacao, dataalteracao
    FROM usuario
   WHERE ativo = TRUE;

CREATE VIEW vw_estados_brasileiros AS
  SELECT id, e.nome, sigla, codigonacao, e.datacriacao, e.dataalteracao
    FROM estado e
   INNER JOIN nacao n on (e.codigonacao = n.codigo)
   where n.nome = 'Brasil';

CREATE VIEW vw_estados_estadunidenses AS
  SELECT id, e.nome, sigla, codigonacao, e.datacriacao, e.dataalteracao
    FROM estado e
   INNER JOIN nacao n on (e.codigonacao = n.codigo)
   where n.nome = 'Estados Unidos';

CREATE VIEW vw_estados_canadenses AS
  SELECT id, e.nome, sigla, codigonacao, e.datacriacao, e.dataalteracao
    FROM estado e
   INNER JOIN nacao n on (e.codigonacao = n.codigo)
   where n.nome = 'Canadá';

CREATE VIEW vw_estados_japoneses AS
  SELECT id, e.nome, sigla, codigonacao, e.datacriacao, e.dataalteracao
    FROM estado e
   INNER JOIN nacao n on (e.codigonacao = n.codigo)
   where n.nome = 'Japão';

CREATE VIEW vw_usuarios_superiores AS
  SELECT U.ID, U.nome
    FROM usuario U
   INNER JOIN nivelacesso N ON (N.id = U.idnivelacesso)
   WHERE N.descricao = 'Superior';

CREATE VIEW vw_usuarios_administradores AS
  SELECT U.ID, U.nome
    FROM usuario U
   INNER JOIN nivelacesso N ON (N.id = U.idnivelacesso)
   WHERE N.descricao = 'Administrador';

CREATE VIEW vw_usuarios_padrao AS
  SELECT U.ID, U.nome
    FROM usuario U
   INNER JOIN nivelacesso N ON (N.id = U.idnivelacesso)
   WHERE N.descricao = 'Padrão';