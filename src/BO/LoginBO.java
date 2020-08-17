package BO;

import dao.LoginDAO;
import database.BasicDatabase;
import database.Postgresql;
import models.User;

/**
 *
 * @author Lucas Oliveira
 */
public class LoginBO {
    private static LoginDAO dao;
    private static BasicDatabase db;
    
    public LoginBO() throws Exception {
        LoginBO.db = new Postgresql();
        LoginBO.dao = new LoginDAO(LoginBO.db);
    }
    
    public boolean checkCredentials(String email, String password) throws Exception {
        return LoginBO.dao.checkCredentials(email, password);
    }

    public User loadUserData(String email) throws Exception {
        return LoginBO.dao.loadUserData(email);
    }
}
