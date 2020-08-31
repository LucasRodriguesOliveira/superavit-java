# superavit-java
Um sistema financeiro feito em java

O projeto tem como propósito um sistema financeiro como trabalho da disciplina de Programação Orientada a Objetos.

Na raiz do projeto, podem ser encontrados os modelos utilizados para criação de um banco de dados relacional juntamento com:

- DML (estrutura)
- Populate (inserções)
- Icons (static files)

Todos os códigos SQL foram criados manualmente seguindo o modelo Todos os códigos SQL foram testados e aprovados em:

- Bancos de dados relacionais (PostgreSQL e Oracle XE)
- WebSQL

## Setup

Para manter o sistema em funcionamento, alguns passos são necessários:
- Na pasta do projeto, acesse a pasta **src**:
 - Acesse a pasta **resources**, onde todos os recursos, como scripts e imagens estão alocados
 - Na pasta **scripts** abra o arquivo DML compatível com seu banco de dados (atualmente somente DML.postgres está atualizado)
 - Execute o código **.sql** para criar todas a tabelas necessárias.
 - Execute também o arquivo **View.<seubancodedados>.sql**
 - Execute também o arquivo **populate.<seubancodedados>.sql**

Com o banco de dados com os modelos configurados, execute o arquivo **functions.<seubancodedados>.sql**. Caso queira averiguar a integridade do sistema, execute **functions.<seubancodedados>.test.sql**, dessa forma serão gravados funções de testes para as funções de banco, porém ainda não foi executado, por isso, é necessário executar a função **execute_test()** (No postgresql: `SELECT execute_test();`)

PostgreSQL: observe a aba "Messages", deve ter uma lista de log's de cada função executada sem erro.
**IMPORTANTE**: execute **populate.<seubancodedados>.sql** antes de **functions.<seubancodedados>.test.sql**

O Sistema utiliza por enquanto algumas informações estáticas sobre o acesso ao banco de dados. Essas informações estão contidas em arquivos `.java` no pacote `contants` onde há várias classes abstratas contendo propriedades de encapsulamento `public`. São constantes (modificador `final`) e estáticas (modificador `static`)! ex:
```java
public abstract class TestConstants {
  public abstract class TEST {
    public static final int X = 0;
    public static final int Y = 0;
    public static final int W = 1300;
    public static final int H = 800;
    public static final String NAME = "TEST";

    public abstract class TITLE {
      public static final int X = 10;
      public static final int Y = 100;
      public static final int W = 250;
      public static final int H = 50;
      public static final String FONT_FAMILY = "Segoe UI";
      public static final int FONT_WEIGHT = Font.BOLD;
      public static final int FONT_SIZE = 20;
      public static final String TEXT = "Texto de teste";
      public static final int R = 43;
      public static final int G = 157;
      public static final int B = 178;
    }
  }
}
```

Isso permite a clareza do código durante a construção da interface:
```java
//other imports
import constants.TestConstants.TEST;

public class TesteView extends BaseView {
  public TesteView(Component parent) {
    super(TEST.NAME, parent);

    initComponents();
  }

  private JLabel getTitleLabel() {
    JLabel lbTitle = new JLabel(TEST.TITLE.TEXT);
    lbTitle.setBounds(TEST.TITLE.X, TEST.TITLE.Y, TEST.TITLE.W, TEST.TITLE.H);
    lbTitle.setForeGround(new Color(TEST.TITLE.R, TEST.TITLE.G, TEST.TITLE.B));
    lbTitle.setFont(new Font(TEST.TITLE.FONT_FAMILY, TEST.TITLE.FONT_WEIGHT, TEST.TITLE.FONT_SIZE));

    return lbTitle;
  }

  private void initComponents() {
    this.setLayout(null);

    this.add(getTitleLabel());
  }
}
```

Portanto, para permitir o sistema o acesso ao banco de dados, é necessário acessar o arquivo **Constants.java** na package **database** e alterar as propriedades da classe **PG** dentro da classe **Contants**

Pronto! O sistema é capaz de acessar o banco de dados especificado!
Como o sistema ainda é incompleto, ainda é necessário algumas coisas:
- O cadastro de usuário é necessário que seja de forma manual, como isso pode acabar se tornando complexo em demasiado, sugiro utilizar algum dos usuários pré-cadastrados no arquivo de **populate** executado anteriormente.

Como a interface ainda não permite a completa navegação, para visualizar uma tela em específico é muito simples:
O sistema foi pensado em facilidade, tanto em uso, quanto em programação, por isso, os testes individuais de cada tela não obrigam a conexão com banco de dados, isto é apenas utilizado para prencher os demais campos da tela, para quando não houver usuário conectados (durante testes), placeholders irão substituir o espaço não utilizado.
Para permitir o teste individual de cada tela e facilitar a adição de novas telas, há um Array de Views no arquivo **MainController** na package **controllers**. Basta comentar ou descomentar qualquer tela, fique a vontade. Compile e execute!