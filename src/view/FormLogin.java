package view;

import components.ActionButton;
import components.Background;
import constants.LoginConstants.LOGIN_FIELD;
import java.awt.Container;
import constants.LoginConstants.EMAIL_INPUT;
import constants.LoginConstants.EMAIL_LABEL;
import constants.LoginConstants.LOGIN_BUTTON;
import constants.LoginConstants.PASS_INPUT;
import constants.LoginConstants.PASS_LABEL;
import controllers.LoginController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author lucas.oliveira
 */
public class FormLogin extends BaseView {
    private Font font;
    private Color color;
    private JTextField email;
    private JPasswordField password;
    private ActionButton accessButton;
    
    private LoginController controller;
    
    public FormLogin(String imgName, String name, Container parent) {
       super(name, parent);
       this.initProperties();
       this.initComponents();
    }
    
    public Background getFormBackground() {
        // Sinceramente, não entendo o por que ser "-10", mesmo que seja relativo
        // a panel atual, não justifica esse comportamento
        // acredito fortemente que depende do sistema operacional ou das
        // configurações do computador
        return new Background(-10, 0, 700, 400, "/resources/FormBackground");
    }
    
    private JLabel getLabelEmail() {
        JLabel lbEmail = new JLabel();
        lbEmail.setFont(font);
        lbEmail.setText(EMAIL_LABEL.TEXT);
        lbEmail.setDisplayedMnemonic(EMAIL_LABEL.MNEMONIC);
        lbEmail.setLabelFor(email);
        lbEmail.setSize(EMAIL_LABEL.W, EMAIL_LABEL.H);
        lbEmail.setLocation(EMAIL_LABEL.X, EMAIL_LABEL.Y);
        lbEmail.setForeground(color);
        lbEmail.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                email.requestFocus();
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        return lbEmail;
    }
    
    private void getInputEmail() {
        JTextField tfEmail = new JTextField();
        tfEmail.setSize(EMAIL_INPUT.W, EMAIL_INPUT.H);
        tfEmail.setLocation(EMAIL_INPUT.X, EMAIL_INPUT.Y);
        tfEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        tfEmail.addKeyListener(new KeyboardActions());
        this.email = tfEmail;
    }
    
    private JLabel getLabelPassword() {
        JLabel lbPass = new JLabel();
        lbPass.setFont(font);
        lbPass.setText(PASS_LABEL.TEXT);
        lbPass.setDisplayedMnemonic(PASS_LABEL.MNEMONIC);
        lbPass.setLabelFor(password);
        lbPass.setSize(PASS_LABEL.W, PASS_LABEL.H);
        lbPass.setLocation(PASS_LABEL.X, PASS_LABEL.Y);
        lbPass.setForeground(color);
        lbPass.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                password.requestFocus();
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        return lbPass;
    }
    
    private void getInputPassword() {
        JPasswordField pfPassword = new JPasswordField();
        pfPassword.setSize(PASS_INPUT.W, PASS_INPUT.H);
        pfPassword.setLocation(PASS_INPUT.X, PASS_INPUT.Y);
        pfPassword.setEchoChar('*');
        pfPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pfPassword.addKeyListener(new KeyboardActions());
        this.password = pfPassword;
    }
    
    private void getLoginButton() {
        this.accessButton =  new ActionButton(LOGIN_BUTTON.X, LOGIN_BUTTON.Y,
                LOGIN_BUTTON.W, LOGIN_BUTTON.H, "Realizar o login",
                LOGIN_BUTTON.IMAGE_PATH, this);
        this.accessButton.addMouseListener(new ClickActions());
    }
    
    class KeyboardActions extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            validateFieldsAllowButton();
        }
    }
    
    class ClickActions extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(((ActionButton) e.getSource()).isState())
                validateCredentials();
        }

        private void validateCredentials() {
            controller.login(email, password, parent);
        }
    }
    
    // Verifica os campos após a digitação, para verificar se pode clicar ou não
    // no botão
    private void validateFieldsAllowButton() {
        if(email.getText().trim().isEmpty()) {
            accessButton.setState(false);
            return; 
        }
        
        if(password.getPassword().length == 0) {
            accessButton.setState(false);
            return;
        }
        
        accessButton.setState(true);
    }
    
    private void initComponents() {
        this.initProps();
    }
    
    @Override
    protected void initProps() {
        this.getInputEmail();
        this.getInputPassword();
        this.getLoginButton();
        
        this.setLayout(null);
        
        this.add(getLabelEmail());
        this.add(email);
        this.add(getLabelPassword());
        this.add(password);
        this.add(accessButton);
        this.add(getFormBackground());
    }

    private void initProperties() {
      this.setBounds(LOGIN_FIELD.X, LOGIN_FIELD.Y, LOGIN_FIELD.W, LOGIN_FIELD.H);
      this.font = new Font("Segoe UI", Font.BOLD, 30);
      this.color = new Color(43, 158, 179);
      this.controller = new LoginController();
    }
}
