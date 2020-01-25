package lro.superavit.view;

import static constants.LoginConstants.CLOSE_BUTTON.H;
import static constants.LoginConstants.CLOSE_BUTTON.W;
import static constants.LoginConstants.CLOSE_BUTTON.X;
import static constants.LoginConstants.CLOSE_BUTTON.Y;
import controllers.LoginController;
import java.awt.Container;
import javax.swing.JPanel;

/**
 *
 * @author lucas.oliveira
 */
public class FormLogin extends BaseView {
    private final String DEFAULT_EXTENSION = ".png";
    
    public FormLogin(int x, int y, int w, int h, String imgName, String name, Container parent) {
       super(name, parent);
       this.initComponents();
    }
    
    private void initComponents() {
        this.initProps();
    }
}
