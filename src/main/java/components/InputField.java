package components;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import constants.InitialConstants;
import static constants.LoginConstants.CLOSE_BUTTON.H;
import static constants.LoginConstants.CLOSE_BUTTON.W;
import static constants.LoginConstants.CLOSE_BUTTON.X;
import static constants.LoginConstants.CLOSE_BUTTON.Y;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author lucas.oliveira
 */
public class InputField extends JPanel {
    protected String value;
    protected ImageIcon hover_image;
    protected int X;
    protected int Y;
    protected int W;
    protected int H;
    protected String iconPath;
    protected ImageIcon back_image;
    protected ImageIcon back_image_hover;
    protected ImageIcon back_image_active;
    protected Cursor cursor_type;
    
    public InputField(int x, int y, int w, int h, String value, Container parent) {
        initProps(x, y, w, h, value);
        setConfigs();
    }
    
    private void initProps(int x, int y, int w, int h, String value) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.iconPath = InitialConstants.CLOSE_BUTTON.IMAGE_PATH;
        this.value = value;
        this.default_image = new ImageIcon(getClass().getResource(iconPath + InitialConstants.CLOSE_BUTTON.IMAGE_EXTENSION));
        this.hover_image = new ImageIcon(getClass().getResource(iconPath + InitialConstants.CLOSE_BUTTON.IMAGE_HOVER_PATH));
        this.cursor_type = new Cursor(Cursor.HAND_CURSOR);
    }

    private void setConfigs() {
        setBounds(X, Y, W, H);
        setCursor(cursor_type);
        addMouseListener(new MouseActions());
        addKeyListener(new KeyboardActions());
    }
    
    class MouseActions extends MouseAdapter {
        
    }
    
    class KeyboardActions extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            value += e.getKeyChar();
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
