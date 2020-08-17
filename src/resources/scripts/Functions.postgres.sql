-----------------------------------------------------------
------------------ [ Getters & Setters ] ------------------
------------------------ [Getters] ------------------------
CREATE OR REPLACE FUNCTION carregaUsuario(
  i_email     USUARIO.EMAIL%TYPE
) RETURNS table (
  id        USUARIO.ID%TYPE,
  nome      USUARIO.NOME%TYPE,
  documento USUARIO.DOCUMENTO%TYPE,
  telefone  USUARIO.TELEFONE%TYPE,
  email     USUARIO.EMAIL%TYPE
) AS $$
BEGIN
  RETURN QUERY
    SELECT USUARIO.ID,
           USUARIO.NOME,
           USUARIO.DOCUMENTO,
           USUARIO.TELEFONE,
           USUARIO.EMAIL
      FROM USUARIO
     WHERE USUARIO.EMAIL = i_email;
END;
$$ LANGUAGE plpgsql;
-----------------------------------------------------------------------------
------------------------------------------------------------------------------
------------------------- [ Setters ] -----------------------------------
CREATE OR REPLACE FUNCTION insereUsuario(
  i_nome              USUARIO.NOME%TYPE,
  i_documento         USUARIO.DOCUMENTO%TYPE,
  i_telefone          USUARIO.TELEFONE%TYPE,
  i_email             USUARIO.EMAIL%TYPE,
  i_senha             USUARIO.SENHA%TYPE,
  i_idtipopessoa      TIPOPESSOA.ID%TYPE,
  i_idnivelacesso     NIVELACESSO.ID%TYPE
) RETURNS VOID AS $$
DECLARE
  v_senha USUARIO.SENHA%TYPE;
BEGIN
  v_senha := crypt(i_senha, gen_salt('bf', 8));

  INSERT INTO USUARIO (nome,
                       documento,
                       telefone,
                       email,
                       senha,
                       idTipoPessoa,
                       idNivelAcesso)
               VALUES (i_nome,
                       i_documento,
                       i_telefone,
                       i_email,
                       v_senha,
                       i_idtipopessoa,
                       i_idnivelacesso);
END;
$$ LANGUAGE PLPGSQL;
-----------------------------------------------------------------------------
------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION insereLogradouro(
  i_nome              LOGRADOURO.NOME%TYPE,
  i_codtipologradouro LOGRADOURO.CODIGOTIPOLOGRADOURO%TYPE
) RETURNS LOGRADOURO.ID%TYPE AS $$
DECLARE
  v_id LOGRADOURO.ID%TYPE;
BEGIN
  BEGIN
    SELECT ID
      INTO v_id
      FROM LOGRADOURO
     WHERE codigotipologradouro = i_codtipologradouro
       AND nome ILIKE i_nome;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      INSERT INTO LOGRADOURO (nome, codigotipologradouro)
        VALUES (i_nome, i_codtipologradouro);

      SELECT ID
        INTO v_id
        FROM LOGRADOURO
       WHERE codigotipologradouro = i_codtipologradouro
         AND nome ILIKE i_nome;
  END;

  RETURN v_id
END;
$$ LANGUAGE PLPGSQL;
-----------------------------------------------------------------------------
------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION insereCep(
  i_codigo   CEP.CODIGO%TYPE,
  i_idcidade CEP.IDCIDADE%TYPE
) RETURNS VOID AS $$
DECLARE
  v_count INTEGER;
BEGIN
  SELECT count(*)
    INTO v_count
    FROM CEP
   WHERE codigo = i_codigo;

  IF v_count = 0 THEN
    INSERT INTO CEP (codigo, idcidade)
      VALUES (i_codigo, i_idcidade);
  END IF;
END;
$$ LANGUAGE PLPGSQL;
-----------------------------------------------------------------------------
------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION insereEndereco(
  i_numero       ENDERECO.NUMERO%TYPE,
  i_bairro       ENDERECO.BAIRRO%TYPE,
  i_complemento  ENDERECO.COMPLEMENTO%TYPE,
  i_referencia   ENDERECO.REFERENCIA%TYPE,
  i_codcep       ENDERECO.CODIGOCEP%TYPE,
  i_idlogradouro ENDERECO.IDLOGRADOURO%TYPE,
  i_idusuario    ENDERECO.IDUSUARIO%TYPE
) RETURNS VOID AS $$
BEGIN
  INSERT INTO ENDERECO (numero,
                        bairro,
                        complemento,
                        referencia,
                        codigocep,
                        idlogradouro,
                        idusuario)
                VALUES (i_numero,
                        i_bairro,
                        i_complemento,
                        i_referencia,
                        i_codcep,
                        i_idlogradouro,
                        i_idusuario);
END;
$$ LANGUAGE PLPGSQL;
-----------------------------------------------------------------------------
------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION cadastraUsuario(
  i_nome              USUARIO.NOME%TYPE,
  i_documento         USUARIO.DOCUMENTO%TYPE,
  i_telefone          USUARIO.TELEFONE%TYPE,
  i_email             USUARIO.EMAIL%TYPE,
  i_senha             USUARIO.SENHA%TYPE,
  i_idtipopessoa      TIPOPESSOA.ID%TYPE,
  i_idnivelacesso     NIVELACESSO.ID%TYPE,
  i_idcidade          CIDADE.ID%TYPE,
  i_codcep            CEP.CODIGO%TYPE,
  i_bairro            ENDERECO.BAIRRO%TYPE,
  i_nomelogradouro    LOGRADOURO.NOME%TYPE,
  i_codtipologradouro TIPOLOGRADOURO.CODIGO%TYPE,
  i_complemento       ENDERECO.COMPLEMENTO%TYPE,
  i_numero            ENDERECO.NUMERO%TYPE,
  i_referencia        ENDERECO.REFERENCIA%TYPE
) RETURNS VOID AS $$
DECLARE
  v_idlogradouro LOGRADOURO.ID%TYPE;
  v_idUsuario    USUARIO.ID%TYPE;
BEGIN
  PERFORM insereUsuario(i_nome, i_documento, i_telefone, i_email, i_senha);
  
  SELECT ID
    INTO v_idUsuario
    FROM carregaUsuario(i_email);

  v_idlogradouro := insereLogradouro(i_nomelogradouro, i_codtipologradouro);

  PERFORM insereCep(i_codcep, i_idcidade);

  PERFORM insereEndereco(i_numero, i_bairro, i_complemento, i_referencia, i_codcep, v_idlogradouro, v_idUsuario);
END;
$$ LANGUAGE plpgsql;
------------------------------------------------------------
------------------------------------------------------------

------------------ { Stored Procedures } -----------------
CREATE OR REPLACE FUNCTION gera_extrato(
  cod_caixa CAIXA.CODIGO%TYPE,
  operacao  VARCHAR, -- ENTRADA (E) / SAÍDA (S)
  montante  CAIXA.SALDO%TYPE
) RETURNS void AS $$
DECLARE
  saldo_caixa  CAIXA.SALDO%TYPE;
  novo_saldo   CAIXA.SALDO%TYPE;
  id_operacao  OPERACAOCAIXA.id%TYPE;
BEGIN
  BEGIN
    SELECT saldo,
           CASE
               WHEN operacao = 'E' THEN (saldo + montante)
               WHEN operacao = 'S' THEN (saldo - montante)
           END novo_saldo
      INTO saldo_caixa,
           novo_saldo
      FROM CAIXA
     WHERE codigo = cod_caixa;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE EXCEPTION 'Caixa não encontrado.';
  END;

  BEGIN
    SELECT id
      INTO id_operacao
      FROM OPERACAOCAIXA
     WHERE (operacao = 'E' AND descricao = 'Débito') OR (operacao = 'S' AND descricao = 'Crédito');
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE EXCEPTION 'Houve um problema ao encontrar dados do sistema.';
  END;

  BEGIN
    INSERT INTO EXTRATO(codigoCaixa, idOperacaoCaixa, valorInicial, valorFinal)
      VALUES (cod_caixa, id_operacao, saldo_caixa, novo_saldo);
  EXCEPTION
    WHEN OTHERS THEN
      RAISE EXCEPTION 'Ocorreu um erro ao registrar o extrato';
  END;
END;
$$ LANGUAGE plpgsql;

------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION atualiza_saldo(
  cod_caixa   CAIXA.CODIGO%TYPE,
  operacao    VARCHAR, -- ENTRADA (E) / SAÍDA (S)
  montante    NUMERIC
) RETURNS void AS $$
DECLARE

BEGIN
  PERFORM gera_extrato(cod_caixa, operacao, montante);

  BEGIN
    IF (operacao = 'E') THEN
      UPDATE CAIXA
         SET saldo = saldo + montante,
             dataalteracao = CURRENT_TIMESTAMP
       WHERE codigo = cod_caixa;
    ELSIF (operacao = 'S') THEN
      UPDATE CAIXA
         SET saldo = saldo - montante,
             dataalteracao = CURRENT_TIMESTAMP
       WHERE codigo = cod_caixa;
    END IF;
  EXCEPTION
    WHEN OTHERS THEN
      RAISE EXCEPTION 'Ocorreu um erro ao registrar dados';
  END;
END;
$$ LANGUAGE plpgsql;

----------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION gera_notificacao(
  cod_usuario USUARIO.ID%TYPE,
  mensagem    NOTIFICACAO.MENSAGEM%TYPE,
  descricao   NOTIFICACAO.DESCRICAO%TYPE
) RETURNS void AS
$$
BEGIN
  INSERT INTO NOTIFICACAO (descricao, idUsuario, mensagem)
    VALUES (descricao, cod_usuario, mensagem);
EXCEPTION
  WHEN OTHERS THEN
    RAISE EXCEPTION 'Ocorreu um erro notificar usuário';
END;
$$ LANGUAGE plpgsql;

--------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION transferencia(
  codusuario_remetente    USUARIO.ID%TYPE,
  codusuario_destinatario USUARIO.ID%TYPE,
  codcaixa_remetente      CAIXA.CODIGO%TYPE,
  montante                CAIXA.SALDO%TYPE,
  mensagem                NOTIFICACAO.MENSAGEM%TYPE
) RETURNS void AS $$
DECLARE
  codcaixa_destinatario CAIXA.CODIGO%TYPE;
BEGIN
  PERFORM atualiza_saldo(codcaixa_remetente, 'S', montante);
  DECLARE
    DESCRICAO        NOTIFICACAO.DESCRICAO%TYPE := 'Você realizou uma transferência de R$ '||TO_CHAR(montante, 'FM99999D00');
    NOME_USUARIO     USUARIO.NOME%TYPE;
  BEGIN
    SELECT NOME
      INTO NOME_USUARIO
      FROM USUARIO
     WHERE ID = codusuario_destinatario;
    
    DESCRICAO := DESCRICAO||' para '||NOME_USUARIO||'.';

    PERFORM gera_notificacao(codusuario_remetente, '', DESCRICAO);
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE EXCEPTION 'Ocorreu um erro ao notificar o usuário.';
  END;

  BEGIN
    SELECT codigo
      INTO codcaixa_destinatario
      FROM CAIXA
     WHERE idusuario = codusuario_destinatario
       AND prioridade = 1;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE EXCEPTION 'Houve um erro ao encontrar dados do recebedor.';
  END;

  PERFORM atualiza_saldo(codcaixa_destinatario, 'E', montante);

  DECLARE
    DESCRICAO        NOTIFICACAO.DESCRICAO%TYPE := ' te enviou um depósito de R$ '||TO_CHAR(montante, 'FM99999D00')||'.';
    NOME_USUARIO     USUARIO.NOME%TYPE;
  BEGIN
    SELECT NOME
      INTO NOME_USUARIO
      FROM USUARIO
     WHERE ID = codusuario_remetente;
    
    DESCRICAO := NOME_USUARIO || DESCRICAO;

    PERFORM gera_notificacao(codusuario_destinatario, mensagem, DESCRICAO);
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE EXCEPTION 'Ocorreu um erro ao notificar o usuário.';
  END;
END;
$$ LANGUAGE plpgsql;

-----------------------------------------------------
CREATE OR REPLACE FUNCTION cria_titulo(
  id_usuario      USUARIO.ID%TYPE,
  id_tipotitulo   TIPOTITULO.ID%TYPE,
  id_categoria    CATEGORIA.ID%TYPE,
  valortotal      PARCELA.VALOR%TYPE,
  nrparcelas      SMALLINT,
  diavencimento   SMALLINT,
  numero_titulo   TITULO.NUMEROTITULO%TYPE
) RETURNS void AS $$
DECLARE
  valor_parcela PARCELA.VALOR%TYPE;
  idTitulo      TITULO.ID%TYPE;
  ano           CONSTANT SMALLINT := EXTRACT(YEAR FROM CURRENT_DATE)::SMALLINT;
BEGIN
  /* Não creio que esta seja a melhor forma de se fazer isso,
    entretanto, não encontrei nada similar a FORALL do Oracle
  */
  valor_parcela := (valortotal / nrparcelas);

  BEGIN
    INSERT INTO TITULO(numeroTitulo, idTipoTitulo, idCategoria, idUsuario)
        VALUES (numero_Titulo, id_tipotitulo, id_categoria, id_usuario);
  EXCEPTION
    WHEN OTHERS THEN
      RAISE EXCEPTION 'Não foi possível registrar o título.';
  END;

  SELECT ID
    INTO idTitulo
    FROM TITULO
   WHERE idUsuario    = id_usuario
     AND idCategoria  = id_categoria
     AND idTipoTitulo = id_tipotitulo
     AND numeroTitulo = numero_titulo
   ORDER BY datacriacao DESC
   LIMIT 1;

  FOR I IN 1..nrparcelas LOOP
    IF(I = nrparcelas AND (nrparcelas * valor_parcela) != valortotal) THEN
      valor_parcela := valor_parcela + (valortotal - (nrparcelas * valor_parcela));
    END IF;

    DECLARE
      data_pagamento  PARCELA.dataPagamento%TYPE;
      mes             CONSTANT SMALLINT := (EXTRACT(MONTH FROM CURRENT_TIMESTAMP) + I)::SMALLINT;
      data_vencimento CONSTANT DATE     := TO_DATE(ano||'/'||mes||'/'||diavencimento, 'YYYY/MM/DD');
    BEGIN
      SELECT
        CASE
            WHEN ID = id_tipotitulo THEN CURRENT_TIMESTAMP
            ELSE NULL
        END dataPagamento
        INTO data_pagamento
        FROM TIPOTITULO
       WHERE nome = 'A vista';

      INSERT INTO PARCELA(idTitulo, valor, dataVencimento, dataPagamento)
        VALUES(idTitulo, valor_parcela, data_vencimento, data_pagamento);
    EXCEPTION
      WHEN OTHERS THEN
        RAISE EXCEPTION 'Houve um erro ao registrar a parcela.';
    END;
  END LOOP;
END;
$$ LANGUAGE plpgsql;
------------------ { Stored Functions } -----------------
CREATE OR REPLACE FUNCTION notif_novousuario()
RETURNS TRIGGER AS
$$
DECLARE
  V_DESCRICAO Notificacao.descricao%type;
  V_MENSAGEM  Notificacao.mensagem%type;
BEGIN
  V_DESCRICAO := 'Boas vindas ao Superavit!';
  V_MENSAGEM  := 'Esperamos que tenha muitos Superavits.';

  PERFORM gera_notificacao(NEW.id, V_MENSAGEM, V_DESCRICAO);

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;
---------------------------------------------------------
CREATE OR REPLACE FUNCTION checklogin(
    i_email VARCHAR,
    i_pass VARCHAR)
  RETURNS boolean AS $$
DECLARE
  v_email usuario.email%type;
  v_pass  usuario.senha%type;
BEGIN
  SELECT email,
         senha
    INTO v_email,
         v_pass
    FROM usuario
   WHERE email = i_email
     AND senha = crypt(i_pass, senha);

  IF v_email IS NOT NULL AND v_pass IS NOT NULL THEN
    RETURN TRUE;
  END IF;

  RETURN FALSE;
END;
$$ LANGUAGE plpgsql;