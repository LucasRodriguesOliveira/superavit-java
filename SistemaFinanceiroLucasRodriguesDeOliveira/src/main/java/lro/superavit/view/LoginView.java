package lro.superavit.view;

import components.AppName;
import components.Background;
import constants.LoginConstants.LOGIN;
import constants.LoginConstants.BACKGROUND;
import constants.LoginConstants.APPNAME;
import java.awt.Container;
/**
 *
 * @author Lucas Oliveira
 */
public class LoginView extends BaseView {
    public LoginView(Container parent) {
        super(LOGIN.NAME, parent);
        this.initComponents();
        this.initProps();
    }
    
    private Background getBackgroundLogin() {
        return new Background(BACKGROUND.X, BACKGROUND.Y,
                BACKGROUND.W, BACKGROUND.H, BACKGROUND.IMAGE_PATH);
    }
    
    private AppName getAppNameImage() {
        return new AppName(APPNAME.X, APPNAME.Y,
                APPNAME.W, APPNAME.H, APPNAME.IMAGE_PATH);
    }

    private void initComponents() {
        this.itens.add(getBackgroundLogin());
        this.itens.add(getAppNameImage());
    }
}
