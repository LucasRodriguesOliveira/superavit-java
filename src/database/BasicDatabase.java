package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import database.Constants.Basic;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
/**
 *
 * @author Lucas Oliveira
 */
public class BasicDatabase {
    protected static Connection connection;
    private final String url;
    private final String host;
    private final String dbname;
    private final String driver;
    private final String user;
    private final String pass;
    private String sql;
    private CallableStatement cs;
    private PreparedStatement ps;
    
    public static final byte TYPE_PROCEDURE = 0;
    public static final byte TYPE_FUNCTION = 1;
    
    public BasicDatabase(String url, String host, String dbname, String driver,
            String user, String pass) {
        this.url = url;
        this.host = host;
        this.dbname = dbname;
        this.driver = driver;
        this.user = user;
        this.pass = pass;
    }
    
    public final boolean tryOpen() throws Exception {
        if(connection != null && !connection.isClosed())
            return true;
        
        try {
            Class.forName(driver);
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", pass);
            connection = DriverManager.getConnection(
              url + host + dbname, props
            );
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            return true;
        } catch(ClassNotFoundException cnfex) {
            throw new Exception(Basic.CNFEX_MSG);
        } catch(SQLException sqlex) {
            throw new Exception(Basic.EX_MSG + sqlex.getMessage());
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void close() throws Exception {
        try{
            if (connection == null || connection.isClosed()) return;
                connection.close();
        }
        catch(SQLException sqlex) {
            throw new Exception(Basic.EX_MSG + sqlex.getMessage());
        }
    }
    
    public ResultSet execute() throws Exception {
        return this.ps.executeQuery();
    }
    
    public void confirmTransaction() throws Exception {
        try{
            if (connection == null || connection.isClosed()) return;
                connection.commit();
        } catch(SQLException sqlex) {
            throw new Exception(Basic.EX_MSG + sqlex.getMessage());
        }
    }
    
    public void cancelTransaction() throws Exception {
        try{
            if (connection == null || connection.isClosed()) return;
                connection.rollback();
        } catch(SQLException sqlex) {
            throw new Exception(Basic.EX_MSG + sqlex.getMessage());
        }
    }
    
    public void prepareFunction(String proc) throws SQLException {
            this.sql = "SELECT * FROM " + proc;
        
        this.ps = Postgresql.connection.prepareStatement(sql);
    }
    
    public void prepare(String sql) throws SQLException {
        this.ps = Postgresql.connection.prepareStatement(sql);
    }
    
    public void setParam(int o, String p) throws SQLException {
        this.ps.setString(o, p);
    }
    
    public void setParam(int o, int p) throws SQLException {
        this.ps.setInt(o, p);
    }
}
