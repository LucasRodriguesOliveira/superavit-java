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
  v_usuario.senha         := COALESCE(i_senha, 'teste123');
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

  SELECT nome,
         documento,
         telefone,
         email,
         senha,
         idTipoPessoa,
         idNivelAcesso
    INTO v_resultado
    FROM USUARIO
   WHERE email = v_email;

  v_pswhash := crypt(v_senha, v_resultado.senha);

  ASSERT v_resultado.nome          = v_nome, 'O Nome de usuário deve ser o mesmo que o inserido';
  ASSERT v_resultado.docuemnto     = v_documento, 'O documento do usuário deve ser o mesmo que o inserido';
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
   ORDER BY datacriacao DESC
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
  v_nome              LOGRADOURO.NOME%TYPE,
  v_codtipologradouro LOGRADOURO.CODIGOTIPOLOGRADOURO%TYPE
  v_nomelogradouro    LOGRADOURO.NOME%TYPE;
BEGIN
  v_nome := 'Teste';

  SELECT codigo
    INTO v_codtipologradouro
    FROM TIPOLOGRADOURO
   WHERE nome = 'Rua';

  SELECT nome
    INTO v_nomelogradouro
    FROM LOGRADOURO
   WHERE id = v_idlogradouro;

  V_idlogradouro := insereLogradouro(v_nome, v_codtipologradouro);

  ASSERT v_idlogradouro IS NOT NULL, 'O Id do logradouro não deve ser nulo';
  ASSERT v_nomelogradouro = v_nome, 'O nome do logradouro deve ser equivalente';
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
END;
$$ LANGUAGE PLPGSQL;