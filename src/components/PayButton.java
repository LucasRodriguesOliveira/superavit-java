package components;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class PayButton extends BaseComponent {
    private String tooltip;
    
    public PayButton(int x, int y, int w, int h, String tooltip, String imagePath) {
        initProps(x, y, w, h, tooltip, imagePath);
        setConfigs();
    }
    
    class Actions extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private void initProps(int x, int y, int w, int h, String tooltip, String imagePath) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.tooltip = tooltip;
        this.default_image = new ImageIcon(getClass().getResource(imagePath + this.DEFAULT_EXTENSION));
    }

    private void setConfigs() {
        setBounds(X, Y, W, H);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setToolTipText(tooltip);
        setIcon(default_image);
        addMouseListener(new Actions());
    }
}
