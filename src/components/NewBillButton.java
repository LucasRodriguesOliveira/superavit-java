package components;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Lucas Oliveira
 */
public final class NewBillButton extends BaseComponent {
    private String tooltip;
    
    public NewBillButton(int x, int y, int w, int h, String t, String i) {
        initComponents(x, y, w, h, t, i);
        setConfigs();
    }
    
    private class Actions extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    public void initComponents(int x, int y, int w, int h, String t, String i) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.default_image = this.getImage(i + DEFAULT_EXTENSION);
        this.tooltip = t;
    }
    
    public void setConfigs() {
        setBounds(X, Y, W, H);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setToolTipText(tooltip);
        setIcon(default_image);
        addMouseListener(new Actions());
    }
    
}
