package components;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public final class SeeAllButton extends BaseComponent {
    private String tooltip;
    private ImageIcon hover_image;
    
    public SeeAllButton(int x, int y, int w, int h, String t, String i) {
        initProps(x, y, w, h, t, i);
        setConfigs();
    }
    
    private class Actions extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setIcon(hover_image);
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            setIcon(default_image);
        }
    }
    
    public void initProps(int x, int y, int w, int h, String t, String i) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.tooltip = t;
        this.default_image = getImage(i + DEFAULT_EXTENSION);
        this.hover_image = getImage(i + " - hover" + DEFAULT_EXTENSION);
    }
    
    public void setConfigs() {
        setBounds(X, Y, W, H);
        addMouseListener(new Actions());
        setToolTipText(tooltip);
        setIcon(default_image);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
