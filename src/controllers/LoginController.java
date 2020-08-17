package controllers;

import BO.LoginBO;
import models.User;
import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.BaseView;
import view.LoginView;

/**
 *
 * @author Lucas Oliveira
 */
public class LoginController {

    private ArrayList<BaseView> form_fields;
    private CardLayout LayoutManager;
    public static LoginController Controller;
    private Container form;
    private final LoginView view;
    private LoginBO bo;

    public LoginController() {
        view = null;

        try {
            this.bo = new LoginBO();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public LoginController(LoginView view) {
        form_fields = new ArrayList<>();
        this.view = view;
    }

    public void login(JTextField email, JPasswordField password, Container parent) {
        boolean valid = false;
        try {
            valid = bo.checkCredentials(email.getText(),
                    String.valueOf(password.getPassword()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        if (valid) {
            Thread userLoader = new Thread(new UserLoader(email.getText()));
            userLoader.setPriority(Thread.MAX_PRIORITY);
            userLoader.setName("UserLoader");
            userLoader.start();
            MainController.Controller.changeView(parent, "HOME");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível se conectar");
            email.requestFocus();
        }
    }
    
    class UserLoader implements Runnable {
        private final String email;
        
        public UserLoader(String email) {
            this.email = email;
        }
        
        @Override
        public void run() {
            try {
                MainController.usuario = bo.loadUserData(this.email);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível recuperar os dados do usuário");
            }
        }
    }

    public CardLayout getLayoutManager() {
        return LayoutManager;
    }

    public void setLayoutManager(CardLayout LayoutManager) {
        this.LayoutManager = LayoutManager;
    }

    public void changeState() {
        view.toggleActiveForm();
    }

    public Container getForm() {
        return form;
    }

    public void setForm(Container form) {
        this.form = form;
    }

    public void initFields() {
        System.out.println("Init method");
    }

    public ArrayList<BaseView> getFields() {
        return this.form_fields;
    }

    public void generateComponents() {
        this.LayoutManager = new CardLayout();
    }

    public void firstField() {
        ((CardLayout) form.getLayout()).first(form);
    }

    public void lastField() {
        ((CardLayout) form.getLayout()).last(form);
    }

    public void previusField() {
        ((CardLayout) form.getLayout()).previous(form);
    }

    public void nextField() {
        ((CardLayout) form.getLayout()).next(form);
    }

    public void changeField(String name) {
        ((CardLayout) form.getLayout()).show(form, name);
    }
}
