package components;

import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class Input extends BaseComponent {
    private ImageIcon focus_image;
    private String value;
    
    public Input(int x, int y, int w, int h, String initialValue, String imagePath) {
        initProps(x, y, w, h, initialValue, imagePath);
    }

    private void initProps(int x, int y, int w, int h, String initialValue, String image) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.value = null == initialValue ? "" : initialValue;
        this.iconPath = image;
        
        String defaultImage = iconPath + image + DEFAULT_EXTENSION;
        String focusImage = iconPath + image + " - focus" + DEFAULT_EXTENSION;
        
//        this.default_image = getImage(defaultImage);
 //       this.focus_image = getImage(focusImage);
        this.cursor_type = new Cursor(Cursor.TEXT_CURSOR);
        
        addFocusListener(new FocusActions());
    }
    
    public String getValue() {
        return this.value;
    }
    
    class FocusActions extends FocusAdapter {
        @Override
        public void focusGained(FocusEvent e) {
            changeImage(focus_image);
        }

        @Override
        public void focusLost(FocusEvent e) {
            changeImage(default_image);
        }
    }
    
    class MouseActions extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            requestFocus();
        }
    }
    
    class KeyActions extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("KeyChar: " + e.getKeyChar());
            System.out.println("KeyCode: " + e.getKeyCode());
            // TODO: set value with keychar
        }
    }
}
