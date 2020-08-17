package components;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class ParcelReportButton extends BaseComponent {
    private String tooltip;
    private ImageIcon hover_image;
    
    public ParcelReportButton(int x, int y, int w, int h, String t, String i) {
        initComponents(x, y, w, h, t, i);
        setConfigs();
    }
    
    class Actions extends MouseAdapter {
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
    
    private void initComponents(int x, int y, int w, int h, String t, String i) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.tooltip = t;
        this.default_image = this.getImage(i + this.DEFAULT_EXTENSION);
        this.hover_image = this.getImage(i + " - hover" + this.DEFAULT_EXTENSION);
    }
    
    private void setConfigs() {
        setBounds(X, Y, W, H);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setToolTipText(tooltip);
        setIcon(default_image);
        addMouseListener(new Actions());
    }
}
