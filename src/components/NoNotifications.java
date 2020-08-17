package components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import constants.HomeConstants.BELL_ICON;
import constants.HomeConstants.NOTIFICATIONS_LABEL;
import constants.HomeConstants.NO_NOTIFICATIONS_TEXT_1;
import constants.HomeConstants.NO_NOTIFICATIONS_TEXT_2;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class NoNotifications extends JPanel {
    public static final String NAME = "NO_NOTIFICATIONS";
    private final String DEFAULT_EXTENSION = ".png";
    
    public NoNotifications(int x, int y, int w, int h, Background b, Background white) {
        initProps(x, y, w, h);
        initComponents(b, white);
    }
    
    private void initProps(int x, int y, int w, int h) {
        this.setBounds(x, y, w, h);
        this.setLayout(null);
    }
    
    protected ImageIcon getImage(String path) {
        return new ImageIcon(getClass().getResource(path));
    }
    
    private JLabel getBellIcon() {
        JLabel bell = new JLabel();
        bell.setBounds(BELL_ICON.X, BELL_ICON.Y, BELL_ICON.W, BELL_ICON.H);
        bell.setIcon(getImage(BELL_ICON.IMAGE_PATH + DEFAULT_EXTENSION));
        
        return bell;
    }
    
    private JLabel getNotificationsLabel() {
        JLabel label = new JLabel();
        label.setBounds(NOTIFICATIONS_LABEL.X, NOTIFICATIONS_LABEL.Y,
            NOTIFICATIONS_LABEL.W, NOTIFICATIONS_LABEL.H);
        label.setIcon(getImage(NOTIFICATIONS_LABEL.IMAGE_PATH + DEFAULT_EXTENSION));
        
        return label;
    }
    
    private JLabel getNoNotificationsText_1() {
        JLabel label = new JLabel(NO_NOTIFICATIONS_TEXT_1.TEXT);
        label.setBounds(NO_NOTIFICATIONS_TEXT_1.X, NO_NOTIFICATIONS_TEXT_1.Y,
            NO_NOTIFICATIONS_TEXT_1.W, NO_NOTIFICATIONS_TEXT_1.H);
        label.setForeground(new Color(NO_NOTIFICATIONS_TEXT_1.R,
            NO_NOTIFICATIONS_TEXT_1.G, NO_NOTIFICATIONS_TEXT_1.B));
        label.setFont(new Font(NO_NOTIFICATIONS_TEXT_1.FONT_FAMILY,
            NO_NOTIFICATIONS_TEXT_1.FONT_WEIGHT, NO_NOTIFICATIONS_TEXT_1.FONT_SIZE));
        
        return label;
    }
    
    private JLabel getNoNotificationsText_2() {
        JLabel label = new JLabel(NO_NOTIFICATIONS_TEXT_2.TEXT);
        label.setBounds(NO_NOTIFICATIONS_TEXT_2.X, NO_NOTIFICATIONS_TEXT_2.Y,
            NO_NOTIFICATIONS_TEXT_2.W, NO_NOTIFICATIONS_TEXT_2.H);
        label.setForeground(new Color(NO_NOTIFICATIONS_TEXT_2.R,
            NO_NOTIFICATIONS_TEXT_2.G, NO_NOTIFICATIONS_TEXT_2.B));
        label.setFont(new Font(NO_NOTIFICATIONS_TEXT_2.FONT_FAMILY,
            NO_NOTIFICATIONS_TEXT_2.FONT_WEIGHT, NO_NOTIFICATIONS_TEXT_2.FONT_SIZE));
        
        return label;
    }
    
    private void initComponents(Background b, Background w) {
        this.add(getBellIcon());
        this.add(getNotificationsLabel());
        this.add(getNoNotificationsText_1());
        this.add(getNoNotificationsText_2());
        this.add(b);
        this.add(w);
    }
}
