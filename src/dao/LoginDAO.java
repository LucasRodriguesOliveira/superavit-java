package dao;

import database.BasicDatabase;
import models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Lucas Oliveira
 */
public class LoginDAO {
    private final BasicDatabase connection;
    
    public LoginDAO(BasicDatabase connection) {
        this.connection = connection;
    }
    
    public boolean checkCredentials(String email, String password) throws Exception {
        try {
          connection.prepareFunction("checkLogin(?, ?) as \"connected\"");
          connection.setParam(1, email);
          connection.setParam(2, password);
          ResultSet rs = connection.execute();
          rs.next();
          
          return rs.getBoolean("connected");
        } catch(SQLException sqlex) {
            throw new Exception(sqlex.getMessage());
        }
    }

    public User loadUserData(String email) throws Exception {
        String sql = "SELECT * FROM carregaUsuario(?);";
        
        try {
            connection.prepare(sql);
            connection.setParam(1, email);
            
            ResultSet rs = connection.execute();
            rs.next();
            
            return new User(rs);
        } catch(SQLException sqlex) {
            throw new Exception(sqlex.getMessage());
        }
    }
}
