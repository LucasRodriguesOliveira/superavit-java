package components;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class PayButtonOperation extends BaseComponent {
    private boolean state;
    protected ImageIcon hover_image;
    protected String tooltip;

    public PayButtonOperation(int x, int y, int w, int h, String tooltip, String imgName) {
        super();
        initProps(x, y, w, h, tooltip, imgName);
        setConfigs();
    }
    
    class Actions extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            if(state) {
                setIcon(default_image);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            } else {
                setIcon(hover_image);
                setCursor(cursor_type);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(state) {
                setIcon(hover_image);
            } else  {
                setIcon(default_image);
            }
            
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
        
        if(state) {
            setIcon(hover_image);
            setCursor(cursor_type);
        } else {
            setIcon(default_image);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    private void initProps(int x, int y, int w, int h, String t, String p) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.state = false;
        this.tooltip = t;
        this.iconPath = p;
        this.default_image = new ImageIcon(getClass().getResource(iconPath + this.DEFAULT_EXTENSION));
        this.hover_image = new ImageIcon(getClass().getResource(iconPath + " - hover" + this.DEFAULT_EXTENSION));
        this.cursor_type = new Cursor(Cursor.HAND_CURSOR);
    }

    private void setConfigs() {
        setIcon(default_image);
        setBounds(X, Y, W, H);
        setCursor(cursor_type);
        addMouseListener(new Actions());
        setToolTipText(tooltip);
    } 
}
