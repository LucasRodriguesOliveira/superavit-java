package lro.superavit.view;

import components.AppName;
import components.Background;
import components.CloseButton;
import components.FormFieldButton;
import constants.LoginConstants.LOGIN;
import constants.LoginConstants.BACKGROUND;
import constants.LoginConstants.APPNAME;
import constants.LoginConstants.CLOSE_BUTTON;
import constants.LoginConstants.FORM;
import constants.LoginConstants.LOGIN_FIELD;
import constants.LoginConstants.SIGNUP_FIELD;
import controllers.LoginController;
import java.awt.Container;
import javax.swing.JPanel;
/**
 *
 * @author Lucas Oliveira
 */
public class LoginView extends BaseView {
    private JPanel form;
    
    public LoginView(Container parent) {
        super(LOGIN.NAME, parent);
        this.initComponents();
    }
    
    private Background getBackgroundLogin() {
        return new Background(BACKGROUND.X, BACKGROUND.Y,
                BACKGROUND.W, BACKGROUND.H, BACKGROUND.IMAGE_PATH);
    }
    
    private AppName getAppNameImage() {
        return new AppName(APPNAME.X, APPNAME.Y,
                APPNAME.W, APPNAME.H, APPNAME.IMAGE_PATH);
    }
    
    private CloseButton getCloseButton() {
        return new CloseButton(CLOSE_BUTTON.X, CLOSE_BUTTON.Y,
                CLOSE_BUTTON.W, CLOSE_BUTTON.H, CLOSE_BUTTON.TOOLTIP, this.parent);
    }
    
    private Background getFormBackground() {
        return new Background(FORM.X, FORM.Y, FORM.W, FORM.H, FORM.BACKGROUND_IMAGE);
    }
    
    private FormFieldButton getLoginButton() {
        return new FormFieldButton(LOGIN_FIELD.X, LOGIN_FIELD.Y,
                LOGIN_FIELD.W, LOGIN_FIELD.H, true, LOGIN_FIELD.IMAGE,
                LoginController.Controller);
    }
    
    private FormFieldButton getSignupButton() {
        return new FormFieldButton(SIGNUP_FIELD.X, SIGNUP_FIELD.Y,
                SIGNUP_FIELD.W, SIGNUP_FIELD.H, false, SIGNUP_FIELD.IMAGE,
                LoginController.Controller);
    }

    private void initComponents() {
        if(LoginController.Controller == null)
            LoginController.Controller = new LoginController();
        
        LoginController.Controller.generateComponents();
        form = new JPanel(LoginController.Controller.getLayoutManager());
        
        this.itens.add(getAppNameImage());
        this.itens.add(getCloseButton());
        this.itens.add(getLoginButton());
        this.itens.add(getSignupButton());
        this.itens.add(getFormBackground());
        this.itens.add(getBackgroundLogin());
        this.initProps();
    }
}
