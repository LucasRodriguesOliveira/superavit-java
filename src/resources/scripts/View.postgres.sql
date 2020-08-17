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

CREATE VIEW vw_extrato_final AS
  SELECT c.nome                             AS "Caixa",
         oc.descricao                       AS "Operação",
         SUM(e.valorFinal - e.valorInicial) AS "Movimentações",
         c.saldo                            AS "Saldo",
         u.id                               AS "Id Usuário",
         u.nome                             AS "Nome Usuário"
    FROM Extrato e
   INNER JOIN Caixa c ON (c.codigo = e.codigoCaixa)
   INNER JOIN OperacaoCaixa oc ON (oc.id = e.idOperacaoCaixa)
   INNER JOIN Usuario u ON (u.id = c.idUsuario)
   WHERE c.ativo
     AND NOT c.excluido
     AND e.ativo
     AND NOT e.excluido
     AND oc.ativo
     AND NOT oc.excluido
   GROUP BY c.nome, oc.descricao, c.saldo, u.id, u.nome
   ORDER BY c.nome ASC, oc.descricao ASC;

CREATE VIEW vw_cobrancas AS
  SELECT us.nome as Solicitante,
       up.nome as Pagador,
       SUM(p.valor),
  CASE
       WHEN p.dataPagamento IS NOT NULL THEN 'Pago'
       ELSE 'Aguardando Pagamento'
   END AS Status
  FROM COBRANCA c
  JOIN Usuario up on (up.id = c.idUsuarioPagador)
  JOIN Usuario us on (us.id = c.idUsuarioSolicitante)
  JOIN Parcela p on (p.idTitulo = c.idTitulo)
 GROUP BY Status, Solicitante, Pagador;

CREATE VIEW vw_notif_nao_lidas AS
  SELECT descricao, idUsuario, mensagem
    FROM Notificacao
   WHERE ativo;

CREATE VIEW vw_notif_lidas AS
  SELECT descricao, idUsuario, mensagem
    FROM Notificacao
   WHERE ativo;