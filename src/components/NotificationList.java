package components;

import constants.HomeConstants;
import constants.HomeConstants.MARK_ALL_AS_READ_BTN;
import constants.HomeConstants.SEE_ALL_BTN;
import constants.HomeConstants.NOTIFICATION_BALLOON_BACK;
import constants.HomeConstants.NOTIFICATION_BALLOON_TEXT;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class NotificationList extends JPanel {
    private JScrollBar sb;
    public static final String NAME = "NOTIFICATION_LIST";
    private final String DEFAULT_EXTENSION = ".png";
    
    public NotificationList(int x, int y, int w, int h, Background b, Background white) {
        initProps(x, y, w, h);
        initComponents(b, white);
    }
    
    protected ImageIcon getImage(String path) {
        return new ImageIcon(getClass().getResource(path));
    }
    
    private JLabel getBellIcon() {
        JLabel bell = new JLabel();
        bell.setBounds(HomeConstants.BELL_ICON.X, HomeConstants.BELL_ICON.Y, HomeConstants.BELL_ICON.W, HomeConstants.BELL_ICON.H);
        bell.setIcon(getImage(HomeConstants.BELL_ICON.IMAGE_PATH + DEFAULT_EXTENSION));
        
        return bell;
    }
    
    private JLabel getNotificationsLabel() {
        JLabel label = new JLabel();
        label.setBounds(HomeConstants.NOTIFICATIONS_LABEL.X, HomeConstants.NOTIFICATIONS_LABEL.Y,
            HomeConstants.NOTIFICATIONS_LABEL.W, HomeConstants.NOTIFICATIONS_LABEL.H);
        label.setIcon(getImage(HomeConstants.NOTIFICATIONS_LABEL.IMAGE_PATH + DEFAULT_EXTENSION));
        
        return label;
    }
    
    private MarkAllAsReadButton getMarkAllAsReadButton() {
        MarkAllAsReadButton markAllAsReadButton = new MarkAllAsReadButton(
            MARK_ALL_AS_READ_BTN.X, MARK_ALL_AS_READ_BTN.Y,
            MARK_ALL_AS_READ_BTN.W, MARK_ALL_AS_READ_BTN.H,
            MARK_ALL_AS_READ_BTN.TOOLTIP, MARK_ALL_AS_READ_BTN.IMAGE_PATH
        );
        
        return markAllAsReadButton;
    }
    
    private SeeAllButton getSeeAllButton() {
        SeeAllButton SeeAllButton = new SeeAllButton(
            SEE_ALL_BTN.X, SEE_ALL_BTN.Y,
            SEE_ALL_BTN.W, SEE_ALL_BTN.H,
            SEE_ALL_BTN.TOOLTIP, SEE_ALL_BTN.IMAGE_PATH
        );
        
        return SeeAllButton;
    }
    
    private NotificationsCountBalloon getNotificationsCountBalloon() {
        NotificationsCountBalloon notificationsCountBalloon = new NotificationsCountBalloon(
            NOTIFICATION_BALLOON_TEXT.X, NOTIFICATION_BALLOON_TEXT.Y, NOTIFICATION_BALLOON_TEXT.W,
            NOTIFICATION_BALLOON_TEXT.H, 0, new Color(NOTIFICATION_BALLOON_TEXT.R,
            NOTIFICATION_BALLOON_TEXT.G, NOTIFICATION_BALLOON_TEXT.B), new Font(
            NOTIFICATION_BALLOON_TEXT.FONT_FAMILY, NOTIFICATION_BALLOON_TEXT.FONT_WEIGHT,
            NOTIFICATION_BALLOON_TEXT.FONT_SIZE)
        );
        
        return notificationsCountBalloon;
    }
    
    private JLabel getBackgroundNotificationsCount() {
        JLabel background = new JLabel(getImage(
                NOTIFICATION_BALLOON_BACK.IMAGE_PATH + DEFAULT_EXTENSION));
        background.setBounds(NOTIFICATION_BALLOON_BACK.X, NOTIFICATION_BALLOON_BACK.Y,
                NOTIFICATION_BALLOON_BACK.W, NOTIFICATION_BALLOON_BACK.H);
        
        return background;
    }
    
    private void initProps(int x, int y, int w, int h) {
        this.setBounds(x, y, w, h);
        this.setLayout(null);
    }
    
    private void initComponents(Background b, Background w) {
        this.add(getNotificationsCountBalloon());
        this.add(getBackgroundNotificationsCount());
        this.add(getBellIcon());
        this.add(getNotificationsLabel());
        this.add(getMarkAllAsReadButton());
        this.add(getSeeAllButton());
        this.add(b);
        this.add(w);
        //this.setScrollBar();
    }
}
