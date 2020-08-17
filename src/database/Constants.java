package database;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class Constants {
    public abstract class Basic {
        public static final String CNFEX_MSG = "Driver não encontrado";
        public static final String SQLEX_MSG = "Falha ocorrida: ";
        public static final String EX_MSG = "Houve um problema ao estabelecer a conexão";
    }
    
    public abstract class PG {
        public static final String DRIVER = "org.postgresql.Driver";
        public static final String BASE_URL = "jdbc:postgresql";
        public static final String HOST = "://localhost";
        public static final String DB = "/test_superavit";
        public static final String USER = "postgres";
        public static final String PASS = "admin"; // valores padrões, pode alterar como necessitar
    }
}
