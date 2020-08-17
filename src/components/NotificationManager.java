package components;

import constants.HomeConstants;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Lucas Oliveira
 */
public class NotificationManager extends JPanel {
    private int X;
    private int Y;
    private int W;
    private int H;
    private CardLayout layout;
    private String background;
    
    private int qtdNotifications;
    
    public NotificationManager(int x, int y, int w, int h, String backImage) {
        initProps(x, y, w, h, backImage);
        setConfigs();
        initialize();
    }
    
    private void initProps(int x, int y, int w, int h, String i) {
        this.layout = new CardLayout();
        this.qtdNotifications = 1; // apenas para testes
        this.background = i;
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
    }
    
    public Background getWhiteBackground() {
        return new Background(0, 0, W, H, HomeConstants.CONTAINER.IMAGE_PATH);
    }
    
    public Background getShadowedBackground() {
        return new Background(0, 0, W, H, background);
    }
    
    private void setConfigs() {
        this.setBounds(X, Y, W, H);
        this.setLayout(layout);
        this.add(NotificationList.NAME,
                new NotificationList(0, 0, W, H, getShadowedBackground(), getWhiteBackground()));
        this.add(NoNotifications.NAME,
                new NoNotifications(0, 0, W, H, getShadowedBackground(), getWhiteBackground()));
    }
    
    private void initialize() {
        if(this.qtdNotifications == 0) {
            layout.show(this, NoNotifications.NAME);
        } else {
            layout.first(this);
        }
    }
}
