package components;

import constants.InitialConstants.CLOSE_BUTTON;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class CloseButton extends Button implements MouseListener {
    
    public CloseButton(int x, int y, int w, int h, String tooltip, Container parent) {
        super(parent);
        initProps(x, y, w, h, tooltip);
        setConfigs();
    }

    public void mouseClicked(MouseEvent e) {
        System.exit(0);
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
        this.setIcon(this.hover_image);
    }

    public void mouseExited(MouseEvent e) {
        this.setIcon(this.default_image);
    }

    private void initProps(int x, int y, int w, int h, String t) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.tooltip = t;
        this.iconPath = CLOSE_BUTTON.IMAGE_PATH;
        this.default_image = new ImageIcon(getClass().getResource(iconPath + CLOSE_BUTTON.IMAGE_EXTENSION));
        this.hover_image = new ImageIcon(getClass().getResource(iconPath + CLOSE_BUTTON.IMAGE_HOVER_PATH));
        this.cursor_type = new Cursor(Cursor.HAND_CURSOR);
    }

    private void setConfigs() {
        setIcon(default_image);
        setBounds(X, Y, W, H);
        setCursor(cursor_type);
        addMouseListener(this);
        setToolTipText(tooltip);
    }
    
}
