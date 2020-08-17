package components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 *
 * @author Lucas Oliveira
 */
public class NotificationsCountBalloon extends BaseComponent {
    private String notifications_count;
    private Font font;
    private Color color;
    
    public NotificationsCountBalloon(int x, int y, int w, int h,
      int count, Color forecolor, Font font) {
        initProps(x, y, w, h, count, forecolor, font);
        setConfigs();
    }

    public String getNotifications_count() {
        return notifications_count;
    }

    public void setNotifications_count(String notifications_count) {
        this.notifications_count = notifications_count;
    }
    
    private void initProps(int x, int y, int w, int h, int count,
            Color forecolor, Font font) {
        this.notifications_count = String.valueOf(count);
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.font = font;
        this.color = forecolor;
    }
    
    private void setConfigs() {
        setBounds(X, Y, W, H);
        setText(notifications_count);
        setForeground(color);
        setFont(font);
        setVerticalAlignment(SwingConstants.CENTER);
    }
}
