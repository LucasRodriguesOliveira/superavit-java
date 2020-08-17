package components;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class MenuItem extends BaseComponent {
    private boolean state;
    private boolean keepActive;
    protected ImageIcon hover_image;
    protected String tooltip;
    
   public MenuItem(int x, int y, int w, int h, String tooltip, String imgPath) {
        super();
        initProps(x, y, w, h, tooltip, imgPath);
        setConfigs();
    }
    
    class Actions extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            hover(true);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            hover(false);
            
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
        hover(state);
    }
    
    public void hover(boolean action) {
        if(state || action) {
            setIcon(hover_image);
            setCursor(cursor_type);
        } else if(!action) {
            setIcon(default_image);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public void setKeepActive(boolean keepActive) {
        this.keepActive = keepActive;
        this.state = keepActive;
    }

    private void initProps(int x, int y, int w, int h, String t, String p) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.state = false;
        this.keepActive = false;
        this.tooltip = t;
        this.iconPath = p;
        this.default_image = new ImageIcon(getClass().getResource(iconPath + this.DEFAULT_EXTENSION));
        this.hover_image = new ImageIcon(getClass().getResource(iconPath + " - ativo" + this.DEFAULT_EXTENSION));
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
