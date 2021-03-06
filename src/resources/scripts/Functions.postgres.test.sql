/*
  Existem formas melhores de se resolver isso, mas no momento, vou manter assim.
*/
--------------------- { Setups } --------------------------------------
CREATE OR REPLACE FUNCTION setup_Usuario(
  i_id            USUARIO.ID%TYPE              DEFAULT NULL,
  i_nome          USUARIO.NOME%TYPE            DEFAULT NULL,
  i_documento     USUARIO.DOCUMENTO%TYPE       DEFAULT NULL,
  i_telefone      USUARIO.TELEFONE%TYPE        DEFAULT NULL,
  i_email         USUARIO.EMAIL%TYPE           DEFAULT NULL,
  i_senha         USUARIO.SENHA%TYPE           DEFAULT NULL,
  i_idtipopessoa  USUARIO.IDTIPOPESSOA%TYPE    DEFAULT NULL,
  i_idnivelacesso USUARIO.IDNIVELACESSO%TYPE   DEFAULT NULL,
  i_datacriacao   USUARIO.DATACRIACAO%TYPE     DEFAULT NULL,
  i_dataalteracao USUARIO.DATAALTERACAO%TYPE   DEFAULT NULL,
  i_ativo         USUARIO.ATIVO%TYPE           DEFAULT NULL,
  i_excluido      USUARIO.EXCLUIDO%TYPE        DEFAULT NULL
)
RETURNS VOID AS $$
DECLARE
  v_usuario       USUARIO%ROWTYPE;
BEGIN
  v_usuario.id            := COALESCE(i_id, -1);
  v_usuario.nome          := COALESCE(i_nome, 'Teste');
  v_usuario.documento     := COALESCE(i_documento, 'teste');
  v_usuario.telefone      := COALESCE(i_telefone, 'teste');
  v_usuario.email         := COALESCE(i_email, 'Teste@teste.com');
  v_usuario.senha         := crypt(COALESCE(i_senha, 'teste123'), gen_salt('bf', 8));
  v_usuario.idtipopessoa  := COALESCE(i_idtipopessoa, 1);
  v_usuario.idnivelacesso := COALESCE(i_idnivelacesso, 1);
  v_usuario.datacriacao   := COALESCE(i_datacriacao, CURRENT_TIMESTAMP);
  v_usuario.dataalteracao := COALESCE(i_dataalteracao, CURRENT_TIMESTAMP);
  v_usuario.ativo         := COALESCE(i_ativo, TRUE);
  v_usuario.excluido      := COALESCE(i_excluido, FALSE);

  INSERT INTO USUARIO VALUES (v_usuario.*);
EXCEPTION
  WHEN UNIQUE_VIOLATION THEN
    UPDATE USUARIO
       SET id             = v_usuario.id,
           nome           = v_usuario.nome,
           documento      = v_usuario.documento,
           telefone       = v_usuario.telefone,
           email          = v_usuario.email,
           senha          = v_usuario.senha,
           idtipopessoa   = v_usuario.idtipopessoa,
           idnivelacesso  = v_usuario.idnivelacesso,
           datacriacao    = v_usuario.datacriacao,
           dataalteracao  = v_usuario.dataalteracao,
           ativo          = v_usuario.ativo,
           excluido       = v_usuario.excluido
     WHERE USUARIO.ID     = v_usuario.ID;
END;
$$ LANGUAGE PLPGSQL;
--------------------------------------------------------------------
-------------------------------------------------------------------
CREATE OR REPLACE FUNCTION setup_Cep(
  i_codigo        CEP.CODIGO%TYPE          DEFAULT NULL,
  i_idcidade      CEP.IDCIDADE%TYPE        DEFAULT NULL,
  i_datacriacao   CEP.DATACRIACAO%TYPE     DEFAULT NULL,
  i_dataalteracao CEP.DATAALTERACAO%TYPE   DEFAULT NULL,
  i_ativo         CEP.ATIVO%TYPE           DEFAULT NULL,
  i_excluido      CEP.EXCLUIDO%TYPE        DEFAULT NULL
)
RETURNS VOID AS $$
DECLARE
  v_cep CEP%ROWTYPE;
BEGIN
  SELECT ID
    INTO v_cep.idcidade
    FROM CIDADE
   LIMIT 1;

  v_cep.codigo        := COALESCE(i_codigo, 'xxxxxxxx');
  v_cep.idcidade      := COALESCE(i_idcidade, v_cep.idcidade);
  v_cep.datacriacao   := COALESCE(i_datacriacao, CURRENT_TIMESTAMP);
  v_cep.dataalteracao := COALESCE(i_dataalteracao, CURRENT_TIMESTAMP);
  v_cep.ativo         := COALESCE(i_ativo, TRUE);
  v_cep.excluido      := COALESCE(i_excluido, FALSE);

  INSERT INTO CEP VALUES (v_cep.*);
EXCEPTION
  WHEN UNIQUE_VIOLATION THEN
    UPDATE CEP
       SET codigo        = v_cep.codigo,
           idcidade      = v_cep.idcidade,
           datacriacao   = v_cep.datacriacao,
           dataalteracao = v_cep.dataalteracao,
           ativo         = v_cep.ativo,
           excluido      = v_cep.excluido
     WHERE CEP.CODIGO    = v_cep.codigo;
END;
$$ LANGUAGE PLPGSQL;
--------------------------------------------------------------------
-------------------------------------------------------------------
CREATE OR REPLACE FUNCTION setup_Logradouro(
  i_id                   LOGRADOURO.ID%TYPE                   DEFAULT NULL,
  i_nome                 LOGRADOURO.NOME%TYPE                 DEFAULT NULL,
  i_codigotipologradouro LOGRADOURO.CODIGOTIPOLOGRADOURO%TYPE DEFAULT NULL,
  i_datacriacao          LOGRADOURO.DATACRIACAO%TYPE          DEFAULT NULL,
  i_dataalteracao        LOGRADOURO.DATAALTERACAO%TYPE        DEFAULT NULL,
  i_ativo                LOGRADOURO.ATIVO%TYPE                DEFAULT NULL,
  i_excluido             LOGRADOURO.EXCLUIDO%TYPE             DEFAULT NULL
)
RETURNS VOID AS $$
DECLARE
  v_logradouro LOGRADOURO%ROWTYPE;
BEGIN
  v_logradouro.id                   := COALESCE(i_id, -1);
  v_logradouro.nome                 := COALESCE(i_nome, 'Rua de Teste');
  v_logradouro.codigotipologradouro := COALESCE(i_codigotipologradouro, 1);
  v_logradouro.datacriacao          := COALESCE(i_datacriacao, CURRENT_TIMESTAMP);
  v_logradouro.dataalteracao        := COALESCE(i_dataalteracao, CURRENT_TIMESTAMP);
  v_logradouro.ativo                := COALESCE(i_ativo, TRUE);
  v_logradouro.excluido             := COALESCE(i_excluido, FALSE);

  INSERT INTO LOGRADOURO VALUES (v_logradouro.*);
EXCEPTION
  WHEN UNIQUE_VIOLATION THEN
    UPDATE LOGRADOURO
       SET id                   = v_logradouro.id,
           nome                 = v_logradouro.nome,
           codigotipologradouro = v_logradouro.codigotipologradouro,
           datacriacao          = v_logradouro.datacriacao,
           dataalteracao        = v_logradouro.dataalteracao,
           ativo                = v_logradouro.ativo,
           excluido             = v_logradouro.excluido
     WHERE LOGRADOURO.ID        = v_logradouro.codigo;
END;
$$ LANGUAGE PLPGSQL;
--------------------------------------------------------------------
-------------------------------------------------------------------
CREATE OR REPLACE FUNCTION setup_tipoCaixa (
  IN    i_id             TIPOCAIXA.ID%TYPE            DEFAULT NULL,
  IN    i_descricao      TIPOCAIXA.DESCRICAO%TYPE     DEFAULT NULL,
  IN    i_datacriacao    TIPOCAIXA.DATACRIACAO%TYPE   DEFAULT NULL,
  IN    i_dataalteracao  TIPOCAIXA.DATAALTERACAO%TYPE DEFAULT NULL,
  IN    i_ativo          TIPOCAIXA.ATIVO%TYPE         DEFAULT NULL,
  IN    i_excluido       TIPOCAIXA.EXCLUIDO%TYPE      DEFAULT NULL
)
RETURNS void AS $$
DECLARE
  v_tipoCaixa TIPOCAIXA%ROWTYPE;
BEGIN
  v_tipoCaixa.id            := COALESCE(i_id, -1);
  v_tipoCaixa.descricao     := COALESCE(i_descricao, 'Descrição de teste');
  v_tipoCaixa.datacriacao   := COALESCE(i_datacriacao, CURRENT_TIMESTAMP);
  v_tipoCaixa.dataalteracao := COALESCE(i_dataalteracao, CURRENT_TIMESTAMP);
  v_tipoCaixa.ativo         := COALESCe(i_ativo, TRUE);
  v_tipoCaixa.excluido      := COALESCE(i_excluido, FALSE);

  INSERT INTO TIPOCAIXA VALUES (v_tipoCaixa.*);

EXCEPTION
  WHEN UNIQUE_VIOLATION THEN
    UPDATE TIPOCAIXA
       SET descricao     = v_tipoCaixa.descricao,
           datacriacao   = v_tipoCaixa.datacriacao,
           dataalteracao = v_tipoCaixa.dataalteracao,
           ativo         = v_tipoCaixa.ativo,
           excluido      = v_tipoCaixa.excluido
     WHERE TIPOCAIXA.id = v_tipoCaixa.id;
END;
$$ LANGUAGE plpgsql;
-------------------------------------------------------------------
-------------------------------------------------------------------
CREATE OR REPLACE FUNCTION setup_moeda (
  IN    i_codigo        MOEDA.CODIGO%TYPE        DEFAULT NULL,
  IN    i_nome          MOEDA.NOME%TYPE          DEFAULT NULL,
  IN    i_simbolo       MOEDA.SIMBOLO%TYPE       DEFAULT NULL,
  IN    i_datacriacao   MOEDA.DATACRIACAO%TYPE   DEFAULT NULL,
  IN    i_dataalteracao MOEDA.DATAALTERACAO%TYPE DEFAULT NULL,
  IN    i_ativo         MOEDA.ATIVO%TYPE         DEFAULT NULL,
  IN    i_excluido      MOEDA.EXCLUIDO%TYPE      DEFAULT NULL
) RETURNS void AS $$
DECLARE
  v_moeda MOEDA%ROWTYPE;
BEGIN
  v_moeda.codigo        := COALESCE(i_codigo, -1);
  v_moeda.nome          := COALESCE(i_nome, 'Nome de Teste');
  v_moeda.simbolo       := COALESCE(i_simbolo, 'x');
  v_moeda.datacriacao   := COALESCE(i_datacriacao, CURRENT_TIMESTAMP);
  v_moeda.dataalteracao := COALESCE(i_dataalteracao, CURRENT_TIMESTAMP);
  v_moeda.ativo         := COALESCE(i_ativo, TRUE);
  v_moeda.excluido      := COALESCE(i_excluido, FALSE);

  INSERT INTO MOEDA VALUES (v_moeda.*);
EXCEPTION
  WHEN UNIQUE_VIOLATION THEN
    UPDATE MOEDA
       SET nome          = v_moeda.nome,
           simbolo       = v_moeda.simbolo,
           datacriacao   = v_moeda.datacriacao,
           dataalteracao = v_moeda.dataalteracao,
           ativo         = v_moeda.ativo,
           excluido      = v_moeda.excluido;
END;
$$ LANGUAGE plpgsql;
-------------------------------------------------------------------
-------------------------------------------------------------------
CREATE OR REPLACE FUNCTION setup_caixa (
  i_codigo        CAIXA.CODIGO%TYPE        DEFAULT NULL,
  i_nome          CAIXA.NOME%TYPE          DEFAULT NULL,
  i_idusuario     CAIXA.IDUSUARIO%TYPE     DEFAULT NULL,
  i_idtipoCaixa   CAIXA.IDTIPOCAIXA%TYPE   DEFAULT NULL,
  i_codigomoeda   CAIXA.CODIGOMOEDA%TYPE   DEFAULT NULL,
  i_corVermelho   CAIXA.CORVERMELHO%TYPE   DEFAULT NULL,
  i_corAzul       CAIXA.CORAZUL%TYPE       DEFAULT NULL,
  i_corVerde      CAIXA.CORVERDE%TYPE      DEFAULT NULL,
  i_prioridade    CAIXA.PRIORIDADE%TYPE    DEFAULT NULL,
  i_saldo         CAIXA.SALDO%TYPE         DEFAULT NULL,
  i_datacriacao   CAIXA.DATACRIACAO%TYPE   DEFAULT NULL,
  i_dataalteracao CAIXA.DATAALTERACAO%TYPE DEFAULT NULL,
  i_ativo         CAIXA.ATIVO%TYPE         DEFAULT NULL,
  i_excluido      CAIXA.EXCLUIDO%TYPE      DEFAULT NULL
)
RETURNS void AS $$
DECLARE
  v_caixa CAIXA%ROWTYPE;
BEGIN
  v_caixa.idusuario := -1;
  v_caixa.idtipoCaixa := -1;
  v_caixa.codigomoeda := -1;
  PERFORM setup_Usuario(i_id => v_caixa.idusuario);
  PERFORM setup_tipoCaixa(i_id => v_caixa.idtipoCaixa);
  PERFORM setup_moeda(i_codigo => v_caixa.codigomoeda);

  v_caixa.codigo        := COALESCE(i_codigo, -1);
  v_caixa.nome          := COALESCE(i_nome, 'Teste');
  v_caixa.idusuario     := COALESCE(i_idusuario, v_caixa.idusuario);
  v_caixa.idtipoCaixa   := COALESCE(i_idtipoCaixa, v_caixa.idtipoCaixa);
  v_caixa.codigomoeda   := COALESCE(i_codigomoeda, v_caixa.codigomoeda);
  v_caixa.corVermelho   := COALESCE(i_corVermelho, 0);
  v_caixa.corAzul       := COALESCE(i_corAzul, 0);
  v_caixa.corVerde      := COALESCE(i_corVerde, 0);
  v_caixa.prioridade    := COALESCE(i_prioridade, 1);
  v_caixa.saldo         := COALESCE(i_saldo, 0);
  v_caixa.datacriacao   := COALESCE(i_datacriacao, CURRENT_TIMESTAMP);
  v_caixa.dataalteracao := COALESCE(i_dataalteracao, CURRENT_TIMESTAMP);
  v_caixa.ativo         := COALESCE(i_ativo, TRUE);
  v_caixa.excluido      := COALESCE(i_excluido, FALSE);

  INSERT INTO CAIXA VALUES (v_caixa.*);
EXCEPTION
  WHEN UNIQUE_VIOLATION THEN
    UPDATE CAIXA
       SET nome          = v_caixa.nome,
           idusuario     = v_caixa.idusuario,
           idtipoCaixa   = v_caixa.idtipoCaixa,
           codigomoeda   = v_caixa.codigomoeda,
           corVermelho   = v_caixa.corVermelho,
           corAzul       = v_caixa.corAzul,
           corVerde      = v_caixa.corVerde,
           prioridade    = v_caixa.prioridade,
           saldo         = v_caixa.saldo,
           datacriacao   = v_caixa.datacriacao,
           dataalteracao = v_caixa.dataalteracao,
           ativo         = v_caixa.ativo,
           excluido      = v_caixa.excluido;
END;
$$ LANGUAGE plpgsql;
--------------------- { Tests } ------------------------------------------
CREATE OR REPLACE FUNCTION test_carregaUsuario()
RETURNS VOID AS $$
DECLARE
  EMAIL_TESTE CONSTANT USUARIO.EMAIL%TYPE := 'teste@teste.com';
  ESPERADO    USUARIO%ROWTYPE;
  RESULTADO   USUARIO%ROWTYPE;
BEGIN
  -- SETUP
  PERFORM setup_Usuario(i_email => EMAIL_TESTE);
  --
  SELECT *
    INTO ESPERADO
    FROM USUARIO
   WHERE USUARIO.EMAIL = EMAIL_TESTE;
  
  RESULTADO := carregaUsuario(EMAIL_TESTE);

  ASSERT RESULTADO.ID IS NOT NULL, 'O id do usuário não pode ser nulo';
  ASSERT RESULTADO.NOME IS NOT NULL, 'O nome do usuário não pode ser nulo';
  ASSERT RESULTADO.DOCUMENTO IS NOT NULL, 'O documento do usuário não pode ser nulo';
  ASSERT RESULTADO.EMAIL IS NOT NULL, 'O email do usuário não pode ser nulo';

  ASSERT RESULTADO.ID = ESPERADO.ID, 'O id do usuário deve ser equivalente ao esperado';
  ASSERT RESULTADO.NOME = ESPERADO.NOME, 'O nome do usuário deve ser equivalente ao esperado';
  ASSERT RESULTADO.DOCUMENTO = ESPERADO.DOCUMENTO, 'O documento do usuário deve ser equivalente ao esperado';
  ASSERT RESULTADO.EMAIL = ESPERADO.EMAIL, 'O email do usuário deve ser equivalente ao esperado';
END;
$$ LANGUAGE PLPGSQL;
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION test_insereUsuario()
RETURNS VOID AS $$
DECLARE
  v_nome          USUARIO.NOME%TYPE;
  v_documento     USUARIO.DOCUMENTO%TYPE;
  v_telefone      USUARIO.TELEFONE%TYPE;
  v_email         USUARIO.EMAIL%TYPE;
  v_senha         USUARIO.SENHA%TYPE;
  v_idtipopessoa  TIPOPESSOA.ID%TYPE;
  v_idnivelacesso NIVELACESSO.ID%TYPE;
  v_resultado     USUARIO%ROWTYPE;
  v_pswhash       USUARIO.SENHA%TYPE;
BEGIN
  v_nome          := 'Teste';
  v_documento     := 'teste';
  v_telefone      := 'teste';
  v_email         := 't_teste@teste.com';
  v_senha         := 'teste123';
  v_idtipopessoa  := 1; -- Física
  v_idnivelacesso := 3; -- Padrão

  PERFORM insereUsuario(
    v_nome,
    v_documento,
    v_telefone,
    v_email,
    v_senha,
    v_idtipopessoa,
    v_idnivelacesso
  );

  SELECT *
    INTO v_resultado
    FROM USUARIO
   WHERE email = v_email;

  v_pswhash := crypt(v_senha, v_resultado.senha);

  ASSERT v_resultado.nome          = v_nome, 'O Nome de usuário deve ser o mesmo que o inserido';
  ASSERT v_resultado.documento     = v_documento, 'O documento do usuário deve ser o mesmo que o inserido';
  ASSERT v_resultado.telefone      = v_telefone, 'O telefone deve ser equivalente';
  ASSERT v_resultado.email         = v_email, 'O E-mail deve ser equivalente';
  ASSERT v_resultado.senha         = v_pswhash, 'A senha deve ser equivalente';
  ASSERT v_resultado.idTipoPessoa  = v_idtipopessoa, 'O Tipo de pessoa deve ser equivalente';
  ASSERT v_resultado.idNivelAcesso = v_idnivelacesso, 'O Nivel de acesso deve ser equivalente';
END;
$$ LANGUAGE PLPGSQL;
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION test_checklogin_when_correct()
RETURNS VOID AS $$
DECLARE
  v_email   CONSTANT USUARIO.EMAIL%TYPE = 'teste@teste.com';
  v_senha   CONSTANT USUARIO.SENHA%TYPE = 'teste123';
  ESPERADO  CONSTANT BOOLEAN = TRUE;
  RESULTADO BOOLEAN;
BEGIN
  -- SETUP
  PERFORM setup_Usuario(i_email => v_email, i_senha => v_senha);
  --

  RESULTADO := checklogin(v_email, v_senha);

  ASSERT RESULTADO = ESPERADO, 'O login deve ser bem sucedido';
END;
$$ LANGUAGE PLPGSQL;

------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION test_checklogin_when_incorrect()
RETURNS VOID AS $$
DECLARE
  v_email   CONSTANT USUARIO.EMAIL%TYPE = 'teste@teste.com';
  v_senha   CONSTANT USUARIO.SENHA%TYPE = 'teste123';
  ESPERADO  CONSTANT BOOLEAN = FALSE;
  RESULTADO BOOLEAN;
BEGIN
  -- SETUP
  PERFORM setup_Usuario(i_email => v_email, i_senha => v_senha);
  --

  RESULTADO := checklogin(v_email, '');

  ASSERT RESULTADO = ESPERADO, 'O login não deve ser bem sucedido';
END;
$$ LANGUAGE PLPGSQL;
----------------------------------------------------------------------
----------------------------------------------------------------------
CREATE OR REPLACE FUNCTION test_gera_notificacao()
RETURNS VOID AS $$
DECLARE
  v_id        CONSTANT USUARIO.ID%TYPE = -1;
  v_mensagem  CONSTANT NOTIFICACAO.MENSAGEM%TYPE = 'Mensagem de Teste';
  v_descricao CONSTANT NOTIFICACAO.DESCRICAO%TYPE = 'Descricao de teste';
  RESULTADO   NOTIFICACAO%ROWTYPE;
BEGIN
  -- Setup
  PERFORM setup_Usuario(i_id => v_id);
  --
  PERFORM gera_notificacao(cod_usuario => v_id,
                           mensagem    => v_mensagem,
                           descricao   => v_descricao);

  SELECT descricao,
         idUsuario,
         mensagem
    INTO RESULTADO.descricao,
         RESULTADO.idUsuario,
         RESULTADO.mensagem
    FROM NOTIFICACAO
   WHERE idUsuario = v_id
     AND mensagem ILIKE v_mensagem
   LIMIT 1;

   ASSERT RESULTADO.idUsuario = v_id, 'O id do usuário que recebeu a notificação deve ser equivalente ao esperado';
   ASSERT RESULTADO.mensagem = v_mensagem, 'A mensagem da notificação deve ser equivalente ao esperado';
   ASSERT RESULTADO.descricao = v_descricao, 'A descrição da notificação deve ser equivalente ao esperado';
END;
$$ LANGUAGE PLPGSQL;
----------------------------------------------------------------------
----------------------------------------------------------------------
CREATE OR REPLACE FUNCTION test_insereLogradouro ()
RETURNS void AS $$
DECLARE
  V_idlogradouro      LOGRADOURO.ID%TYPE;
  v_nome              LOGRADOURO.NOME%TYPE;
  v_codtipologradouro LOGRADOURO.CODIGOTIPOLOGRADOURO%TYPE;
  v_nomelogradouro    LOGRADOURO.NOME%TYPE;
BEGIN
  v_nome := 'Teste';

  SELECT codigo
    INTO v_codtipologradouro
    FROM TIPOLOGRADOURO
   WHERE descricao = 'Rua';

  V_idlogradouro := insereLogradouro(v_nome, v_codtipologradouro);

  SELECT nome
    INTO v_nomelogradouro
    FROM LOGRADOURO
   WHERE id = v_idlogradouro;

  ASSERT v_idlogradouro IS NOT NULL, 'O Id do logradouro não deve ser nulo';
  ASSERT v_nomelogradouro = v_nome, 'O nome do logradouro deve ser equivalente';
END;
$$ LANGUAGE plpgsql;
----------------------------------------------------------------------
----------------------------------------------------------------------
CREATE OR REPLACE FUNCTION test_insereCep ()
RETURNS void AS $$
DECLARE
  v_codigo   CEP.CODIGO%TYPE;
  v_idcidade CEP.IDCIDADE%TYPE;
  v_cep      CEP%ROWTYPE;
BEGIN
  SELECT ID
    INTO v_idcidade
    FROM CIDADE
   LIMIT 1;

  v_codigo := 'xxxxxxxx';

  PERFORM insereCep(v_codigo, v_idcidade);

  SELECT codigo,
         idcidade
    INTO v_cep.codigo,
         v_cep.idcidade
    FROM CEP
   WHERE codigo = v_codigo;
  

  ASSERT v_cep.codigo IS NOT NULL, 'O codigo do cep não deve ser nulo';
  ASSERT v_cep.idcidade IS NOT NULL, 'O codigo da cidade não deve ser nulo';

  ASSERT v_cep.codigo = v_codigo, 'O codigo do cep deve ser equivalente ao cadastrado';
  ASSERT v_cep.idcidade = v_idcidade, 'O codigo da cidade deve ser equivalente ao cadastrado';
END;
$$ LANGUAGE plpgsql;
----------------------------------------------------------------------
----------------------------------------------------------------------
CREATE OR REPLACE FUNCTION test_insereEndereco ()
RETURNS void AS $$
DECLARE
  v_numero       ENDERECO.NUMERO%TYPE;
  v_bairro       ENDERECO.BAIRRO%TYPE;
  v_complemento  ENDERECO.COMPLEMENTO%TYPE;
  v_referencia   ENDERECO.REFERENCIA%TYPE;
  v_codcep       ENDERECO.CODIGOCEP%TYPE;
  v_idlogradouro ENDERECO.IDLOGRADOURO%TYPE;
  v_idusuario    ENDERECO.IDUSUARIO%TYPE;
  v_endereco     ENDERECO%ROWTYPE;
BEGIN
  v_numero       := -1;
  v_bairro       := 'Jardim de Teste';
  v_codcep       := 'xxxxxxxx';
  v_idlogradouro := -1;
  v_idusuario    := -1;

  PERFORM setup_Cep(i_codigo => v_codcep);
  PERFORM setup_Logradouro(i_id => v_idlogradouro);
  PERFORM setup_Usuario(i_id => v_idusuario);

  PERFORM insereEndereco(
    v_numero,
    v_bairro,
    v_complemento,
    v_referencia,
    v_codcep,
    v_idlogradouro,
    v_idusuario
  );

  SELECT *
    INTO v_endereco
    FROM ENDERECO
   WHERE numero       = v_numero
     AND idlogradouro = v_idlogradouro
     AND codigocep    = v_codcep
     AND idusuario    = v_idusuario;
  
  ASSERT v_endereco.numero IS NOT NULL, 'O número do endereço não deve ser nulo';
  ASSERT v_endereco.idlogradouro IS NOT NULL, 'O id do logradouro do endereço não deve ser nulo';
  ASSERT v_endereco.codigocep IS NOT NULL, 'O codigo do cep do endereço não deve ser nulo';
  ASSERT v_endereco.idusuario IS NOT NULL, 'O id do usuário do endereço não deve ser nulo';

  ASSERT v_endereco.numero = v_numero, 'O resultado deve ser equivalente ao cadastrado';
  ASSERT v_endereco.idlogradouro = v_idlogradouro, 'O resultado deve ser equivalente ao cadastrado';
  ASSERT v_endereco.codigocep = v_codcep, 'O resultado deve ser equivalente ao cadastrado';
  ASSERT v_endereco.idusuario = v_idusuario, 'O resultado deve ser equivalente ao cadastrado';
END;
$$ LANGUAGE plpgsql;
----------------------------------------------------------------------
----------------------------------------------------------------------
-- É ideal que test_gera_extrato_entrada seja executado antes de test_gera_extrato_saida
-- Permite aproveitar o valor inserido na entrada
CREATE OR REPLACE FUNCTION test_gera_extrato_entrada ()
RETURNS void AS $$
DECLARE
  v_cod_caixa  CAIXA.CODIGO%TYPE;
  v_operacao   VARCHAR(1);
  v_idOperacao OPERACAOCAIXA.ID%TYPE;
  v_montante   CAIXA.SALDO%TYPE;
  v_extrato    EXTRATO%ROWTYPE;
BEGIN
  v_cod_caixa := -1;
  PERFORM setup_caixa(i_codigo => v_cod_caixa);
  v_operacao := 'E';
  v_montante := 1;

  PERFORM gera_extrato (
    v_cod_caixa,
    v_operacao,
    v_montante
  );

  SELECT ID
    INTO v_idOperacao
    FROM OPERACAOCAIXA
   WHERE descricao ILIKE 'Débito';

  SELECT *
    INTO v_extrato
    FROM EXTRATO
   WHERE codigoCaixa     = v_cod_caixa
     AND idoperacaocaixa = v_idOperacao;

  ASSERT v_extrato.codigoCaixa IS NOT NULL, 'O codigo de caixa não deve ser nulo';
  ASSERT v_extrato.valorInicial IS NOT NULL, 'O valor inicial do caixa não deve ser nulo';
  ASSERT v_extrato.valorFinal IS NOT NULL, 'O valor final do caixa não deve ser nulo';
  ASSERT (v_extrato.valorFinal - v_extrato.valorInicial >= 0), 'A operação deve ser de Entrada';
END;
$$ LANGUAGE plpgsql;
----------------------------------------------------------------------
----------------------------------------------------------------------
-- É ideal que test_gera_extrato_entrada seja executado antes de test_gera_extrato_saida
-- Permite aproveitar o valor inserido na entrada
CREATE OR REPLACE FUNCTION test_gera_extrato_saida ()
RETURNS void AS $$
DECLARE
  v_cod_caixa  CAIXA.CODIGO%TYPE;
  v_operacao   VARCHAR(1);
  v_idOperacao OPERACAOCAIXA.ID%TYPE;
  v_montante   CAIXA.SALDO%TYPE;
  v_extrato    EXTRATO%ROWTYPE;
BEGIN
  v_cod_caixa := -1;
  PERFORM setup_caixa(i_codigo => v_cod_caixa);
  v_operacao := 'S';
  v_montante := 1;

  PERFORM gera_extrato (
    v_cod_caixa,
    v_operacao,
    v_montante
  );

  SELECT ID
    INTO v_idOperacao
    FROM OPERACAOCAIXA
   WHERE descricao ILIKE 'Crédito';

  SELECT *
    INTO v_extrato
    FROM EXTRATO
   WHERE codigoCaixa     = v_cod_caixa
     AND idoperacaocaixa = v_idOperacao;

  ASSERT v_extrato.codigoCaixa IS NOT NULL, 'O codigo de caixa não deve ser nulo';
  ASSERT v_extrato.valorInicial IS NOT NULL, 'O valor inicial do caixa não deve ser nulo';
  ASSERT v_extrato.valorFinal IS NOT NULL, 'O valor final do caixa não deve ser nulo';
  ASSERT (v_extrato.valorFinal - v_extrato.valorInicial <= 0), 'A operação deve ser de Saída';
END;
$$ LANGUAGE plpgsql;
---------------------- { Engine } -------------------------------
CREATE OR REPLACE FUNCTION execute_test()
RETURNS VOID AS $$
BEGIN
  -- Todas as call de teste devem vir aqui
  RAISE NOTICE 'Executando:';
  RAISE NOTICE ' - test_carregaUsuario';
  PERFORM test_carregaUsuario();

  RAISE NOTICE ' - test_insereUsuario';
  PERFORM test_insereUsuario();

  RAISE NOTICE ' - test_checklogin_when_correct';
  PERFORM test_checklogin_when_correct();

  RAISE NOTICE ' - test_checklogin_when_incorrect';
  PERFORM test_checklogin_when_incorrect();

  RAISE NOTICE ' - test_gera_notificacao';
  PERFORM test_gera_notificacao();

  RAISE NOTICE ' - test_insereLogradouro';
  PERFORM test_insereLogradouro();

  RAISE NOTICE ' - test_insereCep';
  PERFORM test_insereCep();

  RAISE NOTICE ' - test_insereEndereco';
  PERFORM test_insereEndereco();

  RAISE NOTICE ' - test_gera_extrato_entrada';
  PERFORM test_gera_extrato_entrada();

  RAISE NOTICE ' - test_gera_extrato_saida';
  PERFORM test_gera_extrato_saida();
END;
$$ LANGUAGE PLPGSQL;