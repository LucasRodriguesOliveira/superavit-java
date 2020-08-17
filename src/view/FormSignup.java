package view;

import components.ActionButton;
import components.Background;
import constants.LoginConstants;
import constants.LoginConstants.PASS_INPUT;
import constants.LoginConstants.REGISTER_BUTTON;
import controllers.MainController;
import java.awt.Color;
import java.awt.Container;
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
 * @author Lucas Oliveira
 */
public class FormSignup extends BaseView {
    private Font font;
    private Color color;
    private JTextField email;
    private JPasswordField password;
    private ActionButton registerButton;
    
    public FormSignup(String imgName, String name, Container parent) {
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
        lbEmail.setText(LoginConstants.EMAIL_LABEL.TEXT);
        lbEmail.setDisplayedMnemonic(LoginConstants.EMAIL_LABEL.MNEMONIC);
        lbEmail.setLabelFor(email);
        lbEmail.setSize(LoginConstants.EMAIL_LABEL.W, LoginConstants.EMAIL_LABEL.H);
        lbEmail.setLocation(LoginConstants.EMAIL_LABEL.X, LoginConstants.EMAIL_LABEL.Y);
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
        tfEmail.setSize(LoginConstants.EMAIL_INPUT.W, LoginConstants.EMAIL_INPUT.H);
        tfEmail.setLocation(LoginConstants.EMAIL_INPUT.X, LoginConstants.EMAIL_INPUT.Y);
        tfEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        tfEmail.addKeyListener(new KeyboardActions());
        this.email = tfEmail;
    }
    
    private JLabel getLabelPassword() {
        JLabel lbPass = new JLabel();
        lbPass.setFont(font);
        lbPass.setText(LoginConstants.PASS_LABEL.TEXT);
        lbPass.setDisplayedMnemonic(LoginConstants.PASS_LABEL.MNEMONIC);
        lbPass.setLabelFor(password);
        lbPass.setSize(LoginConstants.PASS_LABEL.W, LoginConstants.PASS_LABEL.H);
        lbPass.setLocation(LoginConstants.PASS_LABEL.X, LoginConstants.PASS_LABEL.Y);
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
    
    private void getRegisterButton() {
        this.registerButton =  new ActionButton(REGISTER_BUTTON.X, REGISTER_BUTTON.Y,
                REGISTER_BUTTON.W, REGISTER_BUTTON.H, "Realizar o cadastro",
                REGISTER_BUTTON.IMAGE_PATH, this);
        this.registerButton.addMouseListener(new ClickActions());
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
                register();
        }

        // TODO: register method
        private void register() {
            boolean valid = false;
            System.out.println("TODO register method");
            valid = true;
            
            if(valid) {
                MainController.Controller.nextView(parent);
            }
        }
    }
    
    // Verifica os campos após a digitação, para verificar se pode clicar ou não
    // no botão
    private void validateFieldsAllowButton() {
        if(email.getText().trim().isEmpty()) {
            registerButton.setState(false);
            return; 
        }
        
        if(password.getPassword().length == 0) {
            registerButton.setState(false);
            return;
        }
        
        registerButton.setState(true);
    }
    
    private void initComponents() {
        this.initProps();
    }
    
    @Override
    protected void initProps() {
        this.getInputEmail();
        this.getInputPassword();
        this.getRegisterButton();
        
        this.setLayout(null);
        
        this.add(getLabelEmail());
        this.add(email);
        this.add(getLabelPassword());
        this.add(password);
        this.add(registerButton);
        this.add(getFormBackground());
    }

    private void initProperties() {
      this.setBounds(LoginConstants.LOGIN_FIELD.X, LoginConstants.LOGIN_FIELD.Y, LoginConstants.LOGIN_FIELD.W, LoginConstants.LOGIN_FIELD.H);
      this.font = new Font("Segoe UI", Font.BOLD, 30);
      this.color = new Color(43, 158, 179);
    }
}
